/** 方法：构造方法，静态方法，成员方法
 * 代码块：静态代码块，局部代码块
*/
package com.nuist.BasicTest;

public class FunctionTest {
    public String name;
    public int num = 10;

//      构造方法
    public FunctionTest(String name) {
        this.name = name;
    }

    //    成员方法
    public void show() {
        System.out.println("这是成员方法");
    }
//      静态方法，求最大值
    public static int max(int x, int y) {
        return x >= y ? x : y;
    }

//    方法重载，同名，但是参数列表不同
    public static int max(int x, int y, int z) {
        int temp = x >= y ? x : y;
        return temp >= z ? temp : z;
    }

//    可变参数函数，求多个数之和
    public int sum(int ... num) {
        int s = 0;
        for (int x : num) {
            s += x;
        }
        return s;
    }

//    main方法
    public static void main(String[] args) {
//        创建对象
        FunctionTest ft = new FunctionTest("func");
//        打印名字
        System.out.println(ft.name);
//        调用成员方法
        ft.show();
//        调用静态方法
        System.out.println(max(3, 4));
        System.out.println(max(-3,7,5));
//        调用可变参数方法
        int sum = ft.sum(1, 2, 3, 4, 5);
        System.out.println(sum);

    }


}
