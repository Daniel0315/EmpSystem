package com.neuedu.service;

import com.neuedu.entity.Dept;

import java.util.List;

public interface DeptService {

    List<Dept> listDept();

    int deleteDeptById(Integer dept_id);

    int saveDept(Dept dept);

    Dept getDeptById(Integer dept_id);

    int updataById(Dept dept);
}
