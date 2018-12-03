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
import java.util.List;

@WebServlet(urlPatterns = {"/emplist"})
public class EmpListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmpService empService=new EmpServiceImpl();
        List<Emp> empList=empService.listEmp();
        req.setAttribute("emplist",empList);
        req.getRequestDispatcher("emplist.jsp").forward(req,resp);
    }

}
