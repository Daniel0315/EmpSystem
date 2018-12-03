package com.neuedu.servlet;

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

@WebServlet(urlPatterns = "/updataEmpView")
public class UpdataEmpViewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收emp_id并且通过id查询出emp
        Integer emp_id=Integer.parseInt(req.getParameter("emp_id"));
        EmpService empService=new EmpServiceImpl();
        Emp emp=empService.getEmpById(emp_id);
        //查询出所有部门
        DeptService deptService=new DeptServiceImpl();
        List<Dept> deptList=deptService.listDept();
        //绑定数据到request对象上
        req.setAttribute("emp",emp);
        req.setAttribute("deptList",deptList);
        req.getRequestDispatcher("updataEmp.jsp").forward(req,resp);

    }
}
