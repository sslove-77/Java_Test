/** 简单工厂模式
* */
package com.nuist.factory.simple_factory;

public class PersonFactory {
//    私有构造
    private PersonFactory(){}

//    工厂创建Doctor对象
    public static Doctor createDoctor() {
        return new Doctor();
    }

//   工厂创建Police对象
    public static Police createPolice() {
        return new Police();
    }
}
