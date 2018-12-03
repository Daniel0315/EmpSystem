package com.neuedu.service;

import com.neuedu.entity.Emp;

import java.util.List;

public interface EmpService {

    List<Emp> listEmp();

    int deleteEmpById(Integer id);

    int saveEmp(Emp emp);

    Emp getEmpById(Integer emp_id);

    int updataById(Emp emp);

}
