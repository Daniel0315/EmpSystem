package com.neuedu.dao.impl;

import java.sql.Connection;
import com.neuedu.dao.DeptDao;
import com.neuedu.entity.Dept;
import com.neuedu.entity.Emp;
import com.neuedu.util.DruidDataSourceUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeptDaoImpl implements DeptDao {

    @Override
    public List<Dept> listDept() {
        Connection conn=null;
        PreparedStatement psta=null;
        ResultSet re=null;
        List<Dept> deptList=new ArrayList<Dept>();
        try {
            conn=DruidDataSourceUtil.getConnection();
            String sql="select * from dept";
            psta=conn.prepareStatement(sql);
            re=psta.executeQuery();

            while (re.next()){
                deptList.add( new Dept(re.getInt("dept_id"), re.getString("dname"),re.getString("location")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try{
                conn.close();
                psta.close();
                re.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return deptList;
    }

    @Override
    public int deleteDeptById(Integer dept_id) {
        Connection conn=null;
        PreparedStatement psta=null;
        int count=0;
        try {
            conn=DruidDataSourceUtil.getConnection();
            String sql="DELETE from dept where dept_id=?";
            psta=conn.prepareStatement(sql);
           psta.setInt(1,dept_id);
           count=psta.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try{
                conn.close();
                psta.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return count;
    }

    @Override
    public int saveDept(Dept dept) {
        Connection conn=null;
        PreparedStatement psta=null;
        int count=0;
        try {
            conn=DruidDataSourceUtil.getConnection();
            String sql="INSERT into dept (dname,location) values (?,?)";
            psta=conn.prepareStatement(sql);
            psta.setString(1,dept.getDname());
            psta.setString(2,dept.getLocation());
            count=psta.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try{
                conn.close();
                psta.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return count;
    }

    @Override
    public Dept getDeptById(Integer dept_id) {
        Connection conn=null;
        PreparedStatement psta=null;
        ResultSet res=null;
        Dept dept=null;
        try {
            conn=DruidDataSourceUtil.getConnection();
            String sql="select * from dept where dept_id=?";
            psta=conn.prepareStatement(sql);
            psta.setInt(1,dept_id);
            res=psta.executeQuery();
            while (res.next()){
                dept=new Dept(res.getInt("dept_id"),res.getString("dname"),res.getString("location"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try{
                conn.close();
                psta.close();
                res.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return dept;
    }

    @Override
    public int updataById(Dept dept) {
        Connection conn=null;
        PreparedStatement psta=null;
        int count=0;
        try {
            conn=DruidDataSourceUtil.getConnection();
            String sql="update dept set dname=?,location=? where dept_id=?";
            psta=conn.prepareStatement(sql);
            psta.setString(1,dept.getDname());
            psta.setString(2,dept.getLocation());
            psta.setInt(3,dept.getDept_id());
            count=psta.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try{
                conn.close();
                psta.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return count;
    }

}
