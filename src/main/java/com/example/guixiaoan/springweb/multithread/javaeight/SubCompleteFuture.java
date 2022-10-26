package com.example.guixiaoan.springweb.multithread.javaeight;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;

/**
 * @description:
 * @author:gengdd
 * @create: 2022/10/25 15:26
 * @update: 2022/10/25 15:26
 */
public class  SubCompleteFuture<T,V> {

    Function<T,V> function ;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> "xcrj1");
//        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(() -> "xcrj2");
//        CompletableFuture<String> cf3 = CompletableFuture.supplyAsync(() -> "xcrj3");
//        CompletableFuture<Void> allCF = CompletableFuture.allOf(cf1, cf2, cf3);
//        System.out.println("no result");
//
//        CompletableFuture cf4 = CompletableFuture.runAsync(()->{
//            System.out.println(Thread.currentThread().getName()+"-----");
//            System.out.println("1111");
//        });
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            int result = 100;
            System.out.println("一阶段：" + result);
            System.out.println(Thread.currentThread().getName());
            return result;
        }).thenApply(number -> {
            int result = number * 3;
            System.out.println("二阶段：" + result);
            System.out.println(Thread.currentThread().getName());
            return result;
        }).thenApply(number -> {
            int result = number * 3;
            System.out.println("三阶段：" + result);
            System.out.println(Thread.currentThread().getName());
            return result;
        });

        System.out.println("最终结果：" + future.get());

    }







}
