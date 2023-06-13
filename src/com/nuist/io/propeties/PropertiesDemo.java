/** Properties继承自 Hashtable表示一组持久的属性。
 * Properties可以保存到流中或从流中加载。 属性列表中的每个键及其对应的值都是一个字符串。
 * 构造方法
    * Properties()：创建一个没有默认值的空属性列表。
    * Properties(Properties defaults)：创建具有指定默认值的空属性列表。
 *
 * String	getProperty(String key)：使用此属性列表中指定的键搜索属性。
 * String	getProperty(String key, String defaultValue)：使用此属性列表中指定的键搜索属性。
 * Set<String>	stringPropertyNames():返回此属性列表中的一组键，其中键及其对应的值为字符串
 * Object	setProperty(String key, String value): 添加键值对数据
 * void	list(PrintStream out)：将此属性列表打印到指定的输出流。
 * void	list(PrintWriter out)：将此属性列表打印到指定的输出流。

* */
package com.nuist.io.propeties;

import java.util.Properties;
import java.util.Set;

public class PropertiesDemo {
    public static void main(String[] args) {
//        创建对象
        Properties prop = new Properties();

//        将其作为Hashtable的子类使用
        prop.put("苏苏","七七");
        prop.put("苏婷","江涛");
        prop.put("金燕","文涛");

//        它特有的添加数据方法
        prop.setProperty("qq","ss");
        prop.setProperty("st","jt");

//        读取数据
        Set<String> set = prop.stringPropertyNames();
        for (String key : set) {
            System.out.println(key+"--"+prop.getProperty(key));
        }
    }
}
