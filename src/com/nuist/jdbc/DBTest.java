package com.nuist.jdbc;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Helen
 * @date 2023-03-14 15:55
 */
public class DBTest {
    @Test
    public void insertTest() {
//        创建数据库连接对象
        DBUtil dbUtil = new DBUtil();

//        增加数据SQL语句
        String insertSql = "insert into users(id, name, age) values(?,?,?)";

//        参数
        List list = new ArrayList();
        list.add(9);
        list.add("Sali");
        list.add(20);

        System.out.println(dbUtil.modify(insertSql, list));

    }

    @Test
    public void deleteTest() {
        //        创建数据库连接对象
        DBUtil dbUtil = new DBUtil();

//        删除SQL语句
        String deleteSql = "delete from users where id between ? and ?";

//        参数列表
        List list = new ArrayList<>();
        list.add(9);
        list.add(12);

//        返回操作结果数
        System.out.println(dbUtil.modify(deleteSql, list));
    }

    @Test
    public void updateTest() {
        //        创建数据库连接对象
        DBUtil dbUtil = new DBUtil();

//        删除SQL语句
        String updateSql = "update users set age=19 where id > ? ";

//        参数列表
        List list = new ArrayList<>();
        list.add(5);

//        返回操作结果数
        System.out.println(dbUtil.modify(updateSql, list));
    }

    @Test
    public void queryTest() {
        //        创建数据库连接对象
        DBUtil dbUtil = new DBUtil();

//        删除SQL语句
        String querySql = "select * from users where id between ? and ?";

//        参数列表
        List list = new ArrayList<>();
        list.add(4);
        list.add(8);

//        返回操作结果数
        List<Map<String, Object>> query = dbUtil.query(querySql, list);
        System.out.println(query);
//        for (int i = 0; i < query.size(); i++) {
//            System.out.println(query.get(i));
//        }
    }
}
