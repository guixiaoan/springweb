package com.example.guixiaoan.springweb.service;

import com.example.guixiaoan.springweb.utils.SplitUtil;
import com.example.guixiaoan.springweb.vo.FutureTaskWorker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @description:
 * @author:gengdd
 * @create: 2022/9/21 09:16
 * @update: 2022/9/21 09:16
 */
@Service
@Slf4j
public class FutureTaskService {

    @Resource
    private ThreadPoolTaskExecutor asyncExecutor;
    /**
     * 导出fisp数据
     *
     * @param proCodes 专业代码
     */
    public void exportData(List<String> proCodes) {
        StopWatch sw = new StopWatch("导出FISP数据");
        sw.start("异步处理数据");
        List<String> codeList = new ArrayList<String>() ;
        for (int i =0 ;i < 100 ; i++) {
            codeList.add(i+"") ;
        }
        // FISP报表数据
        List<List<String>> fispReportData = Collections.synchronizedList(new ArrayList<>());

        try {
            // 10一组分批次处理(因为目前只支持最多一页40条数据导出, 所以更改至10, 后续如果数据量大可根据情况更改)
            List<List<String>> lists = SplitUtil.getSlitList(codeList, 10);
            lists.forEach((List<String> codes) -> {
                StopWatch innerSw = new StopWatch("异步处理数据");
                innerSw.start("异步处理FISP基础数据...");
                FutureTaskWorker<String, List<String>> dFutureTaskWorker = new FutureTaskWorker<>(codes, this::handelFisp);
                innerSw.stop();

                innerSw.start("异步处理阻塞等待...");
                fispReportData.addAll(dFutureTaskWorker.getAllResult());

                innerSw.stop();
                log.info(innerSw.prettyPrint());
            });
        } catch (Exception e) {
            log.error("导出FISP数据失败...", e);
        }

        log.info(sw.prettyPrint());
    }

    /**
     * 处理FISP数据
     *
     * @param proCode 产品代码
     * @return {@link CompletableFuture}<{@link }>
     */
    @SuppressWarnings("unchecked")
    private CompletableFuture<List<String>> handelFisp(String proCode) {
        return CompletableFuture.supplyAsync(() -> {
            List<String> result = Collections.synchronizedList(new ArrayList<>());
            log.info("handelFisp当前异步线程：{}, 正在处理：{}", Thread.currentThread().getName(), proCode);
            log.info("------------正在执行："+proCode);
            result.add(proCode) ;
            return result;
        }, asyncExecutor);
    }




}
