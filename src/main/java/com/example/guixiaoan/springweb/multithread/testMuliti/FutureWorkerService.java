package com.example.guixiaoan.springweb.multithread.testMuliti;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.function.Function;

/**
 * @description:
 * @author:gengdd
 * @create: 2022/10/25 16:45
 * @update: 2022/10/25 16:45
 */
public class FutureWorkerService {

    public void test () {
        List<String> list = new ArrayList<>() ;
        for (int i= 0 ;i<100;i++) {
            list.add(i+"") ;
        }
        FutureWorker<String,String> worker = new FutureWorker<>(list,this::addInfoSync) ;
        List<String> resultList = worker.getResultList() ;
        System.out.println(resultList.toString());
    }


    public CompletableFuture<String> addInfoSync(String id){
        return CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName()+"--"+id);
            String idTemp = "test"+id ;
            return idTemp ;
        },threadPool()) ;
    }

    public CompletableFuture<String> addInfo(String id){
        final String id1 = id ;
        final String resultId = null ;
        CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                addInfo1(id1) ;
                System.out.println(id1);
                System.out.println(Thread.currentThread().getName()+"----");
            }
        }) ;
        return null;
    }

    public String addInfo1(String id) {
        return "test"+id ;
    }


    public ThreadPoolTaskExecutor threadPool(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

        executor.setCorePoolSize(4); // 核心线程数
        executor.setMaxPoolSize(8); // 最大线程数
        executor.setKeepAliveSeconds(60);  //线程池中允许线程的空闲时间
        executor.setQueueCapacity(200); // 线程池中的队列最大数量
        executor.setThreadNamePrefix("test-sync"+new Random().nextInt(10000));
        executor.setAllowCoreThreadTimeOut(false);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        executor.initialize();

        return executor;
    }

}
