package com.neuedu.util;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DruidDataSourceUtil {
    private static DruidDataSource dataSource;
    static {
        try {
            Properties properties=new Properties();
            properties.load(DruidDataSourceUtil.class.getClassLoader().getResourceAsStream("jdbc.properties"));
            dataSource= (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
            /*dataSource.setDriverClassName("driverClassName");
            dataSource.setUsername("username");
            ;dataSource.setUrl("url");
            dataSource.setPassword("password");*/
            } catch (Exception e) {
            e.printStackTrace();
            dataSource=null;
        }

    }
    public static Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
