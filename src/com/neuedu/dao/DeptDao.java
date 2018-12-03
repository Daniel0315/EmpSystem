package com.neuedu.dao;

import com.neuedu.entity.Dept;
import com.neuedu.entity.Emp;

import java.util.List;

public interface DeptDao {

    List<Dept> listDept();

    int deleteDeptById(Integer dept_id);

    int saveDept(Dept dept);

    Dept getDeptById(Integer dept_id);

    int updataById(Dept dept);
}
