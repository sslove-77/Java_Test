/** 序列化和反序列化
 * 序列化就是将java对象转换成二进制流，便于永久存储在硬盘上，或者通过网络传输到另一个节点
 * 反序列化就是将二进制流转换成其原本的形式

 * 序列化条件：继承Serializable接口
 * 序列化号唯一，保证了反序列化时数据一致，private static final long serialVersionUID = 42L;
 */

package com.nuist.io.stream.serialiable;

import lombok.Data;

import java.io.Serializable;
@Data
public class Person implements Serializable {
    private static final long serialVersionUID = 42L;
    private String name;
    private int age;
//    transient int age;


    public Person() {
        super();
    }

    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
