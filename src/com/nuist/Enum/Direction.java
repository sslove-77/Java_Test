/** 枚举类
    * 定义枚举类要用关键字enum
    * 所有枚举类都是Enum的子类
    * 枚举类第一行必须是枚举项，最后一项后加分号
    * 枚举类可以有构造器，但必须是private，或者默认的
* */
package com.nuist.Enum;

public enum Direction {
//    相当于直接创建了对象
    FRONT("前"){
    @Override
    public void show() {
        System.out.println("前");
    }
    },
    RIGHT("右"){
        @Override
        public void show() {
            System.out.println("右");
        }
    },
    LEFT("左"){
        @Override
        public void show() {
            System.out.println("左");
        }
    },
    BEHIND("后"){
        @Override
        public void show() {
            System.out.println("后");
        }
    };
    private String name;

//    带参构造方法
    Direction(String name) {
        this.name = name;
    }

//    getName方法
    public String getName() {
        return name;
    }

    public abstract void show();
}
