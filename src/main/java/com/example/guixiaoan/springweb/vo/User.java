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
    public int id ;
    public String name ;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
