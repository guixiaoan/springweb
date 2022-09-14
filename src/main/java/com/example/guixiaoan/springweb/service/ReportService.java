package com.example.guixiaoan.springweb.service;

import com.example.guixiaoan.springweb.enumD.ReportEnum;

/**
 * @description:
 * @author:gengdd
 * @create: 2022/9/13 17:44
 * @update: 2022/9/13 17:44
 */
public class ReportService {

    public static void main(String[] args) {
        ReportEnum s = ReportEnum.fromType("R004_FISP") ;
        System.out.println(s);
    }

}
