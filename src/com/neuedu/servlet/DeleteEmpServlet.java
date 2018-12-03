package com.neuedu.servlet;

import com.neuedu.service.EmpService;
import com.neuedu.service.Impl.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/deleteemp")
public class DeleteEmpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取前台传入的参数
        Integer integer=Integer.parseInt(req.getParameter("emp_id"));
        //调用servlet层的删除方法
        EmpService empService=new EmpServiceImpl();
        empService.deleteEmpById(integer);
        //跳转到emplist
        //req.getRequestDispatcher("emplist").forward(req,resp);
        resp.sendRedirect("emplist");
    }
}
