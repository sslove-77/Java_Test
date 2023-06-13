package com.nuist.jdbc3;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author Helen
 * @date 2023-03-21 13:32
 */
public class DBUtils {

//    定义连接变量
    private Connection conn;
    private PreparedStatement statement;
    private ResultSet resultSet;

//    初始化时连接数据库

    public DBUtils() {
        getConn();
    }

    /**
     * 连接数据库
     */
    public Connection getConn() {
        try {
            if (conn == null || conn.isClosed()) {
//                读取数据库配置文件
                InputStream resource = DBUtils.class.getClassLoader().getResourceAsStream("oracle2.properties");
                Properties properties = new Properties();
                properties.load(resource);

//              获取配置信息
                String driver = properties.getProperty("driver");
                String url = properties.getProperty("url");
                String user = properties.getProperty("user");
                String password = properties.getProperty("password");

//               获取数据库驱动
                Class.forName(driver);

//                连接数据库
               this.conn = DriverManager.getConnection(url, user, password);
            }
            return this.conn;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 关闭数据库
     */

    public void closeConn() {
        if (statement != null) {
            try {
                statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.isClosed();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 增删改数据
     */

    public int modifyData(String sql, Object[] args) {
        try {
//            SQL预处理
            statement = conn.prepareStatement(sql);

//            将参数与SQL语句中的？对应
            if (args != null) {
                for (int i = 0; i < args.length; i++) {
                    statement.setObject(i + 1, args[i]);
                }
            }

//            返回执行结果
           return statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            closeConn();
        }
        return 0;
    }

    /**
     * 查询
     */

    public <T> List<T> queryData(Class<T> cls, String sql, Object ... args) {
        try {
            statement = conn.prepareStatement(sql);

//            填充占位符
            if (args != null) {
                for (int i = 0; i < args.length; i++) {
                    statement.setObject(i + 1, args[i]);
                }
            }
            //结果集
            resultSet = statement.executeQuery();
//            表结构
            ResultSetMetaData metaData = resultSet.getMetaData();
//            定义集合存数据
            List<T> list = new ArrayList<>();

            while (resultSet.next()) {
                T t = cls.newInstance();
                Field[] fields = cls.getDeclaredFields();
                for (int i = 1; i <= metaData.getColumnCount(); i++) {

                    String columnLabel = metaData.getColumnLabel(i);
                    Object columnValue = resultSet.getObject(columnLabel);
                    for(Field field : fields){
                        if(field.getName().toUpperCase().equals(columnLabel) ){
                            field.setAccessible(true);
                            field.set(t, columnValue);
                            break;
                        }
                    }
                }
                list.add(t);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            closeConn();
        }
        return null;
    }
}
