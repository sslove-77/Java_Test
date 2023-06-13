package com.nuist.jdbc2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.*;

//数据库工具类
public class DbHelper {

    private Connection connection;

    public DbHelper()
    {
          setConnection();
    }

    public void setConnection()
    {
        try {
            if(connection==null ||  connection.isClosed()) {

                //读取db.properties文件
                InputStream inputStream= new FileInputStream("oracle.properties");
                Properties properties=new Properties();
                properties.load(inputStream);
                String driver=properties.getProperty("driver");
                String url=properties.getProperty("url");
                String uname=properties.getProperty("user");
                String pwd=properties.getProperty("password");
                //1.加载驱动
                Class.forName(driver);
                //2.创建连接对象
                this.connection = DriverManager.getConnection(url, uname, pwd);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//
//    public Connection getConnection() {
//        return this.connection;
//    }


    //执行增删改
    //insert into users values(?,?,?)
    //[1,"aa",18]
    public int  executeUpdate(String sql,List<Object> paramList)
    {
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            if(paramList!=null) {
                for (int i = 0; i < paramList.size(); i++)
                    preparedStatement.setObject(i + 1, paramList.get(i));
            }
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    //执行查询
    public  List<Map<String,Object>>   executeQuery(String sql, List<Object> paramList)
    {
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            //设置参数
            if(paramList!=null)
            {
                for(int i=0;i<paramList.size();i++)
                    preparedStatement.setObject(i+1,paramList.get(i));
            }
            //执行sql
            ResultSet resultSet= preparedStatement.executeQuery();
            //将结果集中的数据读取出来  存到集合中
            //返回的是当前查询出来的表结构中的所有的列的信息
            ResultSetMetaData resultSetMetaData=  resultSet.getMetaData();
            //存放所有的记录
            List<Map<String,Object>> list= new ArrayList<>();
            while(resultSet.next())
            {
                String columnName;
                Object columnValue;
                //查询当前记录中的所有列
                Map<String,Object> map=new HashMap<String,Object>();
                //找到结果集中的字段名
                for(int i=1;i<=resultSetMetaData.getColumnCount();i++) {
                    columnName = resultSetMetaData.getColumnName(i);//获取列的名称
                    columnValue= resultSet.getObject(columnName);//根据列的名称获取列的值
                    //将每一列的数据存入map
                    map.put(columnName,columnValue);// name  'zhangsan'
                }
                //一行已经组装到了一个map中，再将map存入list
                list.add(map);
            }

            return list;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
