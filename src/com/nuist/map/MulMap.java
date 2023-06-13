/** java中单元测试Junit
    1. 导入Junit包
    2. 创建java类，该类必须提供公共的无参构造方法
    3. 类中声明单元测试方法：该方法权限是public，无参无返回值，前面加上注解：@Test
 */

package com.nuist.map;

import com.nuist.classfile.Person;
import org.junit.Test;

import java.util.HashMap;
import java.util.Set;

public class MulMap {
    @Test
    public void test() {
//      嵌套map对象
        HashMap<String, HashMap<String, Person>> hashMap = new HashMap<>();
//      子对象1
        HashMap<String, Person> subMap1 = new HashMap<>();
        subMap1.put("java", new Person("ss", 29,'M'));
        subMap1.put("python", new Person("qq", 27, 'F'));
        subMap1.put("hadoop", new Person("lin", 26, 'F'));

//      子对象2
        HashMap<String, Person> subMap2 = new HashMap<>();
        subMap2.put("oracle", new Person("ss", 29,'M'));
        subMap2.put("hive", new Person("qq", 27, 'F'));
        subMap2.put("mysql", new Person("lin", 26, 'F'));

//        将他们添加到大集合
        hashMap.put("shanghai", subMap1);
        hashMap.put("hangzhou", subMap2);

//        遍历
        Set<String> keySet = hashMap.keySet();
        for (String key : keySet) {
            HashMap<String, Person> subHashMap = hashMap.get(key);
            Set<String> subKey = subHashMap.keySet();
            System.out.println("-----"+key+"-----");
            for (String s : subKey) {
                Person person = subHashMap.get(s);
                System.out.println(s+":"+person.getName()+" "+person.getAge()+" "+ person.getSex());
            }
            System.out.println();
        }
    }
}
