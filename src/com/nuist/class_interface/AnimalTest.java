/** 接口定义 Interface 接口名 {}
 * 接口使用注意事项：
    * 1. java7以前，接口中只能定义全局常量，抽象方法；
    * 2. java8以后，接口中可以定义静态方法，默认方法(default修饰)
    * 3. 接口中的静态方法只能用接口调用，接口中的其他方法可以实现类调用
    * 4. 若父类和接口中含有同名同参数的方法，而子类未重写该方法，默认使用父类方法
    * 5. 若实现类继承的多个接口中含有同名同参数的方法，实现类必须重写该方法，否则报错
    * 6.
 *
 */

package com.nuist.class_interface;

public class AnimalTest {
    public static void main(String[] args) {
//        创建动物对象，多态实现，向上转型
        Animal animal = new Dog();
        animal.setName("Peter");
        animal.setAge(2);
        animal.setColor("black");
        animal.setSex('M');
        animal.show();
        Animal.eat();
        int count = animal.count(1, 2, 3, 4);
        System.out.println(count);
//        animal.dogBehavior();   //子类的方法，父类不可调用，本质上还是Animal对象

        System.out.println(animal.getName()+"-"+animal.getColor()+
                "-"+animal.getAge()+"-"+animal.getSex());
        System.out.println(animal.getClass());
        System.out.println("---------------");

//        向下转型
        Dog d = (Dog) animal;
        d.dogBehavior();
        d.show();
        System.out.println(d.count(1, 2, 3, 4));
        System.out.println("---------------------------");

//        接着使用多态
        animal = new Cat();
        System.out.println(animal.getClass());
        animal.setName("Mary");
        animal.setSex('F');
        animal.age = 3;
        animal.color = "white";
        animal.show();
        Animal.eat();
        System.out.println("-------------");

//        向下转型
        Cat cat = (Cat) animal;
        System.out.println(cat.getName()+"-"+cat.getColor());
        cat.catBehavior();
        cat.fun2();
        Animal.eat();   //相当于自己写了一个静态方法，不是继承

    }
}
