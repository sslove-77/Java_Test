package com.nuist.jdbc;

/**
 * @author Helen
 * @date 2023-03-14 15:28
 */

import java.io.FileInputStream;
import java.sql.*;
import java.util.*;

/**
 * 创建数据库连接
 */
public class DBUtil {
    private Connection connection;

    public DBUtil() {
        setConnection();
    }

    private void setConnection() {
        try {
//            如果连接为空或者连接关闭则重新开启连接
            if (connection == null || connection.isClosed()) {
//                读取配置文件
                FileInputStream inputStream = new FileInputStream("oracle.properties");
                Properties properties = new Properties();
                properties.load(inputStream);

//                获取属性值
                String driver = properties.getProperty("driver");
                String url = properties.getProperty("url");
                String user = properties.getProperty("user");
                String password = properties.getProperty("password");

//                加载驱动
                Class.forName(driver);

//                创建链接对象
                this.connection = DriverManager.getConnection(url, user, password);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 执行增删改操作
     */

    public int modify(String sql, List<Object> list) {
        try {
//            SQL预处理，进行校验，防止SQL注入
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

//            参数列表不为空时，填充占位符
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    preparedStatement.setObject(i + 1, list.get(i));
                }
            }
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 查询功能
     */

    public List<Map<String, Object>> query(String sql, List<Object> list) {
        try {
//            预处理
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

//          判断参数是否为空
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    preparedStatement.setObject(i + 1, list.get(i));
                }
            }


//           创建集合和map存储数据

            List<Map<String, Object>> mapList = new ArrayList<>();

//            获取结果集
            ResultSet resultSet = preparedStatement.executeQuery();

//            获取表结构
            ResultSetMetaData metaData = resultSet.getMetaData();

            while (resultSet.next()) {
                Map<String, Object> map = new HashMap<>();
                //            获取每行列名和对应值
                String colName;
                String colLabel;
                Object value;

                //
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    colName = metaData.getColumnName(i);
//                    colLabel= metaData.getColumnLabel(i);
                    value = resultSet.getObject(colName);
                    map.put(colName, value);
                }
                list.add(mapList);
            }

            return mapList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
