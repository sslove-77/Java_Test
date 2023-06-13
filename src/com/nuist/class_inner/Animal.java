package com.nuist.class_inner;

import lombok.Data;

@Data
public class Animal {
    public static int num = 10;

//    定义静态方法
    public static void eat() {
        System.out.println("动物吃什么呢？");
    }

//    定义一般方法
    public void show() {
        System.out.println("动物类");
    }

//    成员内部类
    static class Sub1 {
//       定义变量num2
        public int num2 = 20;
//        定义求和方法
        public int sum() {
            return num + num2;
        }

        public void fun() {
//            调用外部类方法
//            show();  // 当内部类定义为静态时，他只能调用静态方法
            eat();
        }

    }


    //    定义局部内部类
    public void display() {
        class Sub2{
            public int num3 = 30;
            public int sum2() {
                return num + num3;
            }

            public void fun2() {
//                调用外部类方法
                show();
                eat();
            }
        }
        Sub2 sub2 = new Sub2();
        sub2.fun2();
        System.out.println(sub2.sum2());

    }
}
