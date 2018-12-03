package com.neuedu.servlet;

import com.neuedu.service.DeptService;
import com.neuedu.service.Impl.DeptServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(urlPatterns = "/deleteDept")
public class DeleteDeptServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer integer=Integer.parseInt(req.getParameter("dept_id"));

        DeptService deptService=new DeptServiceImpl();
        deptService.deleteDeptById(integer);

        resp.sendRedirect("deptlist");
    }
}
