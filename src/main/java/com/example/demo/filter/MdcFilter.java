package com.example.demo.filter;

import com.example.demo.utils.Utils;
import org.slf4j.MDC;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MdcFilter implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        MDC.put("ReqIP", Utils.getClientIp(request));
        MDC.put("ReqURI", request.getRequestURI());
        MDC.put("ReqType", request.getMethod());
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        MDC.remove("ReqIP");
        MDC.remove("ReqURI");
        MDC.remove("ReqType");
    }

}
