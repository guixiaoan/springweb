package com.example.guixiaoan.springweb.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author:gengdd
 * @create: 2022/9/109:43
 * @update: 2022/9/109:43
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User1 {

    private String id ;

    private String name ;

    private String age ;
}
