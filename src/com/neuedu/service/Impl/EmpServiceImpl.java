package com.neuedu.service.Impl;

import com.neuedu.dao.DeptDao;
import com.neuedu.dao.EmpDao;
import com.neuedu.dao.impl.DeptDaoImpl;
import com.neuedu.dao.impl.EmpDaoImpl;
import com.neuedu.entity.Dept;
import com.neuedu.entity.Emp;
import com.neuedu.service.EmpService;

import java.sql.SQLException;
import java.util.List;

public class EmpServiceImpl implements EmpService {
    @Override
    public List<Emp> listEmp() {

        EmpDao empDao=new EmpDaoImpl();
        List<Emp> empList= null;
        try {
            empList = empDao.listEmp();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //查询所有部门信息
        DeptDao deptDao=new DeptDaoImpl();
        List<Dept> deptList=deptDao.listDept();


        //拼装信息
        for (Emp emp : empList) {
            for (Dept dept : deptList) {
                if (emp.getDept_id().equals(dept.getDept_id())){
                    emp.setDept(dept);
                }
            }
        }

        return empList;
    }


    @Override
    public int deleteEmpById(Integer id) {
        EmpDao empDao=new EmpDaoImpl();
        return empDao.deleteEmpById(id);
    }

    @Override
    public int saveEmp(Emp emp) {
        EmpDao empDao=new EmpDaoImpl();
        return empDao.saveEmp(emp);
    }

    @Override
    public Emp getEmpById(Integer emp_id) {
        EmpDao empDao=new EmpDaoImpl();
        return empDao.getEmpById(emp_id);
    }

    @Override
    public int updataById(Emp emp) {
        EmpDao empDao=new EmpDaoImpl();
        return empDao.updataById(emp);
    }


}
