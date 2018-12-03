package com.neuedu.filter;

import com.neuedu.entity.User;
import com.neuedu.service.Impl.UserServiceImpl;
import com.neuedu.service.UserService;
import com.sun.jndi.toolkit.url.Uri;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter("")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;


        String uri = request.getRequestURI();

        if (uri.endsWith(".js")||uri.endsWith(".css")||uri.endsWith("login")||uri.endsWith(".jsp")) {
            filterChain.doFilter(request, response);
        } else {
            //获取传过来的session
            HttpSession session = request.getSession();
            if (session.getAttribute("username") == null) {

                //未登录

                String uname = null;
                String pword = null;
                Cookie[] cookie = request.getCookies();
                if (cookie != null) {
                    boolean islogin=false;
                    for (Cookie c : cookie) {
                        if (c.getName().equals("username")) {
                            uname = c.getValue();
                            UserService userService = new UserServiceImpl();
                            User user = userService.getUserByUsername(uname);
                            session.setAttribute("user", user);
                            request.setAttribute("user",user);
                        }
                    }
                    if (!islogin){
                        response.sendRedirect("login.jsp");
                    }

                } else {
                    response.sendRedirect("login.jsp");
                }

            } else {
                filterChain.doFilter(request, response);
            }


        }
    }
    @Override
    public void destroy() {

    }
}
