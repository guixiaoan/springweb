package com.example.guixiaoan.springweb.multithread.testMuliti;

/**
 * @description:
 * @author:gengdd
 * @create: 2022/10/26 16:44
 * @update: 2022/10/26 16:44
 */
public class TestFuture {
    public static void main(String[] args) {
        FutureWorkerService service = new FutureWorkerService() ;
        service.test();
    }
}
