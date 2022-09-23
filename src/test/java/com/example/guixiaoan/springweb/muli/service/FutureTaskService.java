package com.example.guixiaoan.springweb.muli.service;

import com.example.guixiaoan.springweb.muli.FutureTaskWorker;
import com.example.guixiaoan.springweb.muli.util.SplitUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
     * test多线程
     * @param proCodes
     */
    public void exportFispData(List<String> proCodes) {
        StopWatch sw = new StopWatch("异步测试");
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
   * @description: 测试分割
   * @creater:gengdd
   * @createTime:2022/9/21 10:31
   * @Param:
   * @return:
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
