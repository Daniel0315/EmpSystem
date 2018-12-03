package com.neuedu.servlet;

import com.neuedu.entity.User;
import com.neuedu.service.Impl.UserServiceImpl;
import com.neuedu.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.HttpCookie;

@WebServlet("/login")
public class LoginServlet  extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService=new UserServiceImpl();
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        User user=userService.getUserByUsername(username);

        if (user!=null&&user.getPassword().equals(password)){

            //设置session的值
            HttpSession session=req.getSession();
            session.setAttribute("user",user);

            //设置cookies
            Cookie usernamecookies=new Cookie("username",username);
            Cookie passwordcookies=new Cookie("password",password);
            usernamecookies.setMaxAge(60*60*24*7);
            passwordcookies.setMaxAge(60*60*24*7);
            resp.addCookie(usernamecookies);
            resp.addCookie(passwordcookies);

            resp.sendRedirect("index.jsp");
        }else {

            resp.sendRedirect("login.jsp");
        }

    }
}
