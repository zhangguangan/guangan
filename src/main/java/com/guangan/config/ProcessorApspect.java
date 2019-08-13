package com.guangan.config;


import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
public class ProcessorApspect {

    private final static String POINT_CUT__EXPRESSION = "execution(* com.guangan.business..*(..))";

    private static final Logger logger = Logger.getLogger(ProcessorApspect.class);
    private PathMatcher pathMatcher = new AntPathMatcher();

    @Pointcut(POINT_CUT__EXPRESSION)
    public void pointCut() {

    }

    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        System.out.println(JSONObject.toJSONString(requestAttributes));
        HttpServletRequest request = requestAttributes.getRequest();
        logger.info("前置通知开启=====================");

        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));

        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
    }
    @After("pointCut()")
    public void after() {

    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        Object object =  joinPoint.proceed();
        return object;
    }
}
