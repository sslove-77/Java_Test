package com.nuist.jdbc3;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Helen
 * @date 2023-03-23 21:12
 */

@Data
public class Users {

//    定义id，姓名，年龄
    private BigDecimal id;
    private String name;
    private BigDecimal age;

    public Users() {
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
