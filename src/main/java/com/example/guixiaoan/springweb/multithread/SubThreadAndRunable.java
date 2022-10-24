package com.example.guixiaoan.springweb.multithread;

/**
 * @description:
 * @author:gengdd
 * @create: 2022/10/24 10:57
 * @update: 2022/10/24 10:57
 */
public class SubThreadAndRunable {
    public static void main(String[] args) {
        for(int i = 0 ;i< 10;i++) {
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"mmm"+ finalI);
                }
            }).start(); ;
        }

    }
}
