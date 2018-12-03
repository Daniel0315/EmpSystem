package com.neuedu.dao.impl;

import com.neuedu.dao.UserDao;
import com.neuedu.entity.Emp;
import com.neuedu.entity.User;
import com.neuedu.util.DruidDataSourceUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public User getUserByUsername(String username) {
        Connection conn = null;
        PreparedStatement psta = null;
        ResultSet re = null;
        User user=null;
        try {
            conn = DruidDataSourceUtil.getConnection();
            String sql = "select * from e_user where username=?";
            psta = conn.prepareStatement(sql);
            psta.setString(1,username);
            re = psta.executeQuery();

            while (re.next()) {
                user=new User(re.getInt("user_id"),
                        re.getString("username"), re.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
                psta.close();
                re.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }
}
