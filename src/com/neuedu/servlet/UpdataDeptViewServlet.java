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
@WebServlet(urlPatterns = "/updataDeptView")
public class UpdataDeptViewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer dept_id=Integer.parseInt(req.getParameter("dept_id"));
        DeptService deptService=new DeptServiceImpl();
        Dept dept=deptService.getDeptById(dept_id);
        req.setAttribute("dept",dept);
        req.getRequestDispatcher("updataDept.jsp").forward(req,resp);
    }
}
