package com.example.guixiaoan.springweb.vo;

/**
 * @description:
 * @author:gengdd
 * @create: 2022/9/16 18:01
 * @update: 2022/9/16 18:01
 */
public class Test {
    public static void main(String[] args) {
        switch ("3") {
            // 我待办
            case "1":
            case "3":
                System.out.println("3333");
                // 待提交
            case "2":
                System.out.println("222");
                break;
            // 我发起
            // 已办理
            default:
                System.out.println("444");

        }
    }
}
