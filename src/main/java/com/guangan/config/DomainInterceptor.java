package com.guangan.config;


import com.guangan.business.CacheProxy;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DomainInterceptor implements HandlerInterceptor {
    @Resource
    private CacheProxy cacheProxy;
    private static final Logger logger = Logger.getLogger(DomainInterceptor.class);
    private static final String TOKEN_KEY = "TOKEN_KEY";

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
//        String path = httpServletRequest.getServletPath();
////        System.out.println(path);
////        Integer tokenNumber = cacheProxy.decr(TOKEN_KEY);
////
////        if (tokenNumber > 1) {
////            return true;
////        } else {
////            logger.error("限流");
////            throw new RuntimeException("限流");
////        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
