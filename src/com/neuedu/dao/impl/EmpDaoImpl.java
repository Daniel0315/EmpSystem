package com.neuedu.dao.impl;

import com.neuedu.dao.EmpDao;
import com.neuedu.entity.Emp;
import com.neuedu.util.DruidDataSourceUtil;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDaoImpl implements EmpDao{


    @Override
    public List<Emp> listEmp() {
       Connection conn=null;
        PreparedStatement psta=null;
        ResultSet re=null;
        List<Emp> empList=new ArrayList<Emp>();
        try {
            conn=DruidDataSourceUtil.getConnection();
            String sql="select * from emp";
           psta=conn.prepareStatement(sql);
            re=psta.executeQuery();

            while (re.next()){
                empList.add( new Emp(re.getInt("emp_id"),
                        re.getString("ename"),re.getString("phone"),
                        re.getString("sex"),re.getInt("salary"),
                        re.getInt("dept_id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                conn.close();
                psta.close();
                re.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }
        return empList;
    }

    /**
     * 通过id删除数据
     * @param
     * @return
     */
    @Override
    public int deleteEmpById(Integer id) {
        Connection conn=null;
        PreparedStatement psta=null;
        int count = 0;
        try {
            conn=DruidDataSourceUtil.getConnection();
            String sql="DELETE FROM emp where emp_id=?";
            psta=conn.prepareStatement(sql);
            psta.setInt(1,id);
            count=psta.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                conn.close();
                psta.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return count;
    }

    @Override
    public int saveEmp(Emp emp) {
        Connection conn=null;
        PreparedStatement psta=null;
        int count = -1;
        try {
            conn=DruidDataSourceUtil.getConnection();
            String sql="insert into emp (ename,phone,sex,salary,dept_id) values (?,?,?,?,?)";
            psta=conn.prepareStatement(sql);
            psta.setString(1,emp.getName());
            psta.setString(2,emp.getPhone());
            psta.setString(3,emp.getSex());
            psta.setInt(4,emp.getSalary());
            psta.setInt(5,emp.getDept_id());
            count=psta.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                conn.close();
                psta.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return count;
    }

    @Override
    public Emp getEmpById(Integer emp_id) {
        Connection conn=null;
        PreparedStatement psta=null;
        ResultSet re=null;
        Emp emp=null;
        try {
            conn=DruidDataSourceUtil.getConnection();
            String sql="SELECT * from emp where emp_id=?";
            psta=conn.prepareStatement(sql);
            psta.setInt(1,emp_id);
            re=psta.executeQuery();

            while (re.next()){
                emp=new Emp(re.getInt("emp_id"),
                        re.getString("ename"),re.getString("phone"),
                        re.getString("sex"),re.getInt("salary"),
                        re.getInt("dept_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                conn.close();
                psta.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return emp;
    }

    @Override
    public int updataById(Emp emp) {
        Connection conn=null;
        PreparedStatement psta=null;
        int count = 0;
        try {
            conn=DruidDataSourceUtil.getConnection();
            String sql="update emp set ename=?,phone=?,sex=?,salary=?,dept_id=? where emp_id=? ";
            psta=conn.prepareStatement(sql);
            psta.setString(1,emp.getName());
            psta.setString(2,emp.getPhone());
            psta.setString(3,emp.getSex());
            psta.setInt(4,emp.getSalary());
            psta.setInt(5,emp.getDept_id());
            psta.setInt(6,emp.getEmp_id());
            count=psta.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                conn.close();
                psta.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return count;
    }
}