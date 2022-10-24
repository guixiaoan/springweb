package com.example.guixiaoan.springweb.multithread;

/**
 * @description:
 * @author:gengdd
 * @create: 2022/10/24 10:51
 * @update: 2022/10/24 10:51
 */
public class SubRunable implements Runnable{

    public static void main(String[] args) {
        SubRunable x = new SubRunable() ;
        Thread t1 = new Thread(x) ;
        t1.start();
        SubRunable y = new SubRunable() ;
        Thread t2 = new Thread(y) ;
        t2.start();
    }

    @Override
    public void run() {
        for (int i= 0; i< 100 ;i++) {
            System.out.println(Thread.currentThread().getName()+"xxx"+i);
        }

    }
}
