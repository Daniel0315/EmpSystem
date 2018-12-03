package com.neuedu.dao;

import com.neuedu.entity.Emp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface EmpDao {

    List<Emp> listEmp() throws SQLException;

    int deleteEmpById(Integer id);

    int saveEmp(Emp emp);

    Emp getEmpById(Integer emp_id);

    int updataById(Emp emp);


}
