package com.nuist.Enum;

public class DirectionTest {
    public static void main(String[] args) {
//        创建对象
        Direction d = Direction.BEHIND;
        System.out.println(d);   // 本来应该打印地址，枚举重写了toString方法
        System.out.println(d.getName());   // 后
        d.show();

//        重新赋值
        d = Direction.LEFT;
        System.out.println(d.name());   // LEFT
        System.out.println(d.getName());  // 左

        Direction d2 = Direction.valueOf(Direction.class, "RIGHT");
        System.out.println(d2);   // RIGHT
        System.out.println(d2.toString());   //RIGHT
        System.out.println(d2.ordinal());  //返回序数1

    }
}
