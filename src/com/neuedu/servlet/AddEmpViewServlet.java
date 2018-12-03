package com.neuedu.servlet;

import com.neuedu.dao.DeptDao;
import com.neuedu.dao.impl.DeptDaoImpl;
import com.neuedu.entity.Dept;
import com.neuedu.entity.Emp;
import com.neuedu.service.DeptService;
import com.neuedu.service.EmpService;
import com.neuedu.service.Impl.DeptServiceImpl;
import com.neuedu.service.Impl.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/addEmpView")
public class AddEmpViewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       //将查询到的数据发送到后台
        DeptService deptService=new DeptServiceImpl();
        List<Dept> deptList=deptService.listDept();
        //绑定到request上
        req.setAttribute("deptList",deptList);
        req.getRequestDispatcher("addEmp.jsp").forward(req,resp);

    }
}
