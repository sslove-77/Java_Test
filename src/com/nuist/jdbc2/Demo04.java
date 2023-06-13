package com.nuist.jdbc2;

import java.util.List;
import java.util.Map;

public class Demo04 {

    public static void main(String[] args) {

        DbHelper dbHelper=new DbHelper();

        String sql="select * from fruits";

        List<Map<String,Object>> list=  dbHelper.executeQuery(sql,null);

        System.out.println(list);

    }
}
