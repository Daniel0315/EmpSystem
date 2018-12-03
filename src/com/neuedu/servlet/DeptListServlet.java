package com.neuedu.servlet;

import com.neuedu.dao.DeptDao;
import com.neuedu.dao.impl.DeptDaoImpl;
import com.neuedu.entity.Dept;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/deptlist")
public class DeptListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DeptDao deptDao=new DeptDaoImpl();
       List<Dept>deptList=deptDao.listDept();
        req.setAttribute("deptlist",deptList);
        req.getRequestDispatcher("deptlist.jsp").forward(req,resp);
    }
}
