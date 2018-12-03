package com.neuedu.service.Impl;

import com.neuedu.dao.DeptDao;
import com.neuedu.dao.impl.DeptDaoImpl;
import com.neuedu.entity.Dept;
import com.neuedu.service.DeptService;

import java.util.List;

public class DeptServiceImpl implements DeptService {

    @Override
    public List<Dept> listDept() {
        DeptDao deptDao=new DeptDaoImpl();
        return deptDao.listDept();
    }

    @Override
    public int deleteDeptById(Integer dept_id) {
        DeptDao deptDao=new DeptDaoImpl();
        return deptDao.deleteDeptById(dept_id);
    }

    @Override
    public int saveDept(Dept dept) {
        DeptDao deptDao=new DeptDaoImpl();
        return deptDao.saveDept(dept);
    }

    @Override
    public Dept getDeptById(Integer dept_id) {
        DeptDao deptDao=new DeptDaoImpl();
        return deptDao.getDeptById(dept_id);
    }

    @Override
    public int updataById(Dept dept) {
        DeptDao deptDao=new DeptDaoImpl();
        return deptDao.updataById(dept);
    }
}
