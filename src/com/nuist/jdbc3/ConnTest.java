package com.nuist.jdbc3;

import org.junit.Test;

import java.sql.Connection;
import java.util.List;

/**
 * @author Helen
 * @date 2023-03-21 13:55
 */
public class ConnTest {
    @Test
    public void insertTest() {
//        连接
        DBUtils dbUtils = new DBUtils();
        Connection conn = dbUtils.getConn();

//        sql语句
        String sql = "insert into users(id, name, age) values(?,?,?)";

//        传参
        Object[] args = {1, "Susan", 17};
        int i = dbUtils.modifyData(sql, args);
        System.out.println(i);
        dbUtils.closeConn();
    }

    @Test
    public void updateTest() {
        //        连接
        DBUtils dbUtils = new DBUtils();

//        sql语句
        String sql = "update users set id = ? where id = ?";

//        传参
        Object[] args = {22, 9};
        int i = dbUtils.modifyData(sql, args);
        System.out.println(i);
    }

    @Test
    public void deleteTest() {
        //        连接
        DBUtils dbUtils = new DBUtils();

//        sql语句
        String sql = "delete from users where id in (?,?)";

//        传参
        Object[] args = {22, 8};
        int i = dbUtils.modifyData(sql, args);
        System.out.println(i);
    }

    @Test
    public void queryTest() {
        //        连接
        DBUtils dbUtils = new DBUtils();

//        sql语句
        String sql = "select id,name,age from users where id = ?";
//        参数
        Object[] args = {6};

        List<Users> users = dbUtils.queryData(Users.class, sql, args);
        System.out.println(users);
        System.out.println(users);
    }
}
