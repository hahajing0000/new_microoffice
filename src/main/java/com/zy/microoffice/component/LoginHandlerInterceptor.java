package com.zy.microoffice.component;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURL = request.getRequestURL().toString();
        if (requestURL.contains("/index/") || requestURL.contains("/calendar/") || requestURL.contains("/stat/")) {
            Object user = request.getSession().getAttribute("phonenumber");
            System.out.println("preHandle----" + user + " ::: " + request.getRequestURL());
            if (user == null) {
                request.setAttribute("msg", "无权限请先登录");
                // 获取request返回页面到登录页
                //request.getRequestDispatcher("/login.html").forward(request, response);
                response.sendRedirect("/");
                return false;
            }
        }


        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        Object user = request.getSession().getAttribute("phonenumber");
        System.out.println("postHandle----" + user + " ::: " + request.getRequestURL());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        Object user = request.getSession().getAttribute("phonenumber");
        System.out.println("afterCompletion----" + user + " ::: " + request.getRequestURL());
    }
}
