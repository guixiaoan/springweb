package com.example.guixiaoan.springweb.multithread;

/**
 * @description:
 * @author:gengdd
 * @create: 2022/10/24 10:37
 * @update: 2022/10/24 10:37
 */
public class SubThread extends Thread {
    @Override
    public void run() {
        for (int i = 0 ;i < 100 ;i++) {
            System.out.println(Thread.currentThread().getName()+"____"+i);
        }

    }

    public static void main(String[] args) {
        SubThread t1 = new SubThread() ;
        t1.start();

        Thread t2 = new Thread() {
            @Override
            public void run() {
                for (int i = 0 ;i < 100 ;i++) {
                    System.out.println(Thread.currentThread().getName()+"----"+i);
                }

            }
        };
        t2.start();


        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t3") ;
            }
        }) ;
        t3.start();
    }
}
