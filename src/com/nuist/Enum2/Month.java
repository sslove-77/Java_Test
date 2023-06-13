package com.nuist.Enum2;

public enum Month {
    //    枚举项
    JANUARY("一月"){
        @Override
        public void show() {
            System.out.println("Jan");
        }
    },
    FEBRUARY("二月") {
        @Override
        public void show() {
            System.out.println("Feb");
        }
    },
    MARCH("三月") {
        @Override
        public void show() {
            System.out.println("Mar");
        }
    },
    APRIL("四月") {
        @Override
        public void show() {
            System.out.println("Apr");
        }
    },
    MAY("五月"){
        @Override
        public void show() {
            System.out.println("May");
        }
    },
    JUNE("六月"){
        @Override
        public void show() {
            System.out.println("Jun");
        }
    },
    JULY("七月"){
        @Override
        public void show() {
            System.out.println("Jul");
        }
    };

//    定义变量name
    private String name;
//    构造方法
    Month(String name) {
        this.name = name;
    }

    public String  getName() {
        return name;
    }

    //    定义抽象方法
    public abstract void show();

}
