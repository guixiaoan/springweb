package com.example.guixiaoan.springweb.multithread.testMuliti;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @description:
 * @author:gengdd
 * @create: 2022/10/25 16:39
 * @update: 2022/10/25 16:39
 */
@AllArgsConstructor
@Data
public class FutureWorker<T,R>{
    List<T> workList ;

    public List<T> getWorkList() {
        return workList;
    }

    public FutureWorker(Function<T, CompletableFuture<R>> workFunction) {
        this.workFunction = workFunction;
    }

    public void setWorkList(List<T> workList) {
        this.workList = workList;
    }

    Function<T, CompletableFuture<R>> workFunction ;


    public List<R> getResultList() {
        List<CompletableFuture<R>> futureList = workList.stream().map(workFunction).collect(Collectors.toList()) ;
        CompletableFuture<Void> allCompletableFuture = CompletableFuture.allOf(futureList.toArray(new CompletableFuture[futureList.size()])) ;
        List<R> rList = allCompletableFuture.thenApply(e -> futureList.stream().map(CompletableFuture::join).collect(Collectors.toList())).join();
        return rList ;
    }
}
