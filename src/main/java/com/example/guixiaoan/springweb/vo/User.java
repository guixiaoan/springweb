package com.example.guixiaoan.springweb.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author:gengdd
 * @create: 2022/8/3118:10
 * @update: 2022/8/3118:10
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id ;
    private String name ;

}
