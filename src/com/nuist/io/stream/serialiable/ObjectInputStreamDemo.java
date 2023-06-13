/** 序列化与反序列化流
 * ObjectInputStream，ObjectOutputStream
 * 如果修改了类中的数据，反序列化读取对象会报错，序列化号对不上，因此需要在类声明中写上序列化号
        private static final long serialVersionUID = 42L;
 *
 *对于一个实体类，不想将所有的属性都进行序列化，有专门的关键字 transient：
    * private transient String name;   //使用transient关键字后，该变量的值读取不到，使用默认值
* */
package com.nuist.io.stream.serialiable;

import org.junit.Test;

import java.io.*;

public class ObjectInputStreamDemo {

    @Test
    public void read() throws IOException, ClassNotFoundException {
        //        创建反序列化对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("serializable.dat"));
//      反序列化
        Object obj = ois.readObject();
        System.out.println(obj);
        ois.close();
    }

    @Test
     public void write() throws IOException{
        //        创建对象
        Person p = new Person();
        p.setName("风清扬");
        p.setAge(35);
//        创建序列化对象
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("serializable.dat"));
//        序列化
        oos.writeObject(p);
//        释放资源
        oos.close();
    }
}
