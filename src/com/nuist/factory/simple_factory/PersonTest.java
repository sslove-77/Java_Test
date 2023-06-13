package com.nuist.factory.simple_factory;

public class PersonTest {
    public static void main(String[] args) {
//      用工厂直接创建对象
        Doctor doctor = PersonFactory.createDoctor();
        Police police = PersonFactory.createPolice();

        doctor.work();
        police.work();
    }
}
