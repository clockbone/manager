package com.clockbone.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by qinjun on 2016/2/5.
 */
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Enumeration<String> e =  filterConfig.getInitParameterNames();
        while (e.hasMoreElements()){
            String key = e.nextElement();
            String value = filterConfig.getInitParameter(key);
            //todo something...
            System.out.println(key + value);
        }

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        //找不到用户登录信息返回
        String userName = (String)request.getSession().getAttribute("userName");
        //todo something...
        /*
        if(null == userName||"".equals(userName)){
            response.sendRedirect("login");
            return;
        }else{
            filterChain.doFilter(servletRequest,servletResponse);
        }
        */
        filterChain.doFilter(servletRequest,servletResponse);

    }

    @Override
    public void destroy() {

    }
}
