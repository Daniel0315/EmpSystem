package com.neuedu.servlet;

import com.neuedu.entity.Emp;
import com.neuedu.service.EmpService;
import com.neuedu.service.Impl.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/addEmp")
public class AddEmpServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name=req.getParameter("name");
        String phone=req.getParameter("phone");
        String sex=req.getParameter("sex");
        Integer salary=Integer.parseInt(req.getParameter("salary"));
        Integer dept=Integer.parseInt(req.getParameter("dept_id"));

        EmpService empService=new EmpServiceImpl();
        empService.saveEmp(new Emp(name,phone,sex,salary,dept));
        resp.sendRedirect("emplist");
    }
}
