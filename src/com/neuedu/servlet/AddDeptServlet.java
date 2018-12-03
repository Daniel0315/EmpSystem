package com.neuedu.servlet;

import com.neuedu.entity.Dept;
import com.neuedu.service.DeptService;
import com.neuedu.service.Impl.DeptServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(urlPatterns = "/addDept")
public class AddDeptServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        String dname=req.getParameter("dname");
        String location=req.getParameter("location");
        DeptService deptService=new DeptServiceImpl();
        deptService.saveDept(new Dept(dname,location));
        resp.sendRedirect("deptlist");

    }
}
