package com.nuist.class_anonymous;

public class AnonymousImpl {
    public void display() {
        Anonymous anonymous = new Anonymous() {
            @Override
            public void show() {
                System.out.println("匿名内部类");
            }

            @Override
            public int sum(int num1, int num2) {
                return num1+num2;
            }
        };
        anonymous.show();
        System.out.println(anonymous.sum(3,5));
    }
}
