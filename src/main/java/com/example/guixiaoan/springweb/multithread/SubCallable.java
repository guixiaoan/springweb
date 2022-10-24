package com.example.guixiaoan.springweb.multithread;


import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @description:
 * @author:gengdd
 * @create: 2022/10/24 16:44
 * @update: 2022/10/24 16:44
 */
public class SubCallable implements Callable {
    @Override
    public Object call() throws Exception {
        Random r = new Random() ;
        int i =  r.nextInt(100) ;
        return i;
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SubCallable myCallAble = new SubCallable() ;
        for (int i = 0 ;i < 100 ;i++) {
            FutureTask<Integer> futureTask = new FutureTask<>(myCallAble) ;
            Thread t = new Thread(futureTask) ;
            t.start();
            System.out.println(Thread.currentThread().getName()+"---"+futureTask.get() );
        }


    }
}
