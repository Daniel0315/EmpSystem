package com.neuedu.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
@WebListener
public class CountListener implements HttpSessionListener {
   private Integer num=0;
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        num++;
        //设置全局变量
       ServletContext context=httpSessionEvent.getSession().getServletContext();
       context.setAttribute("num",num);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        num--;
        ServletContext context=httpSessionEvent.getSession().getServletContext();
        context.setAttribute("num",num);
    }
}
