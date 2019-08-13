package com.guangan.controller;

import com.guangan.business.CacheProxy;
import com.guangan.business.Teacher;
import com.guangan.config.SpringContext;
import com.guangan.po.UserPo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
public class HelloController {
    @Resource
    private Teacher teacher;

    @Resource
    private CacheProxy cacheProxy;
    @ResponseBody
    @RequestMapping("/hello")

    public String hello() {
        teacher = (Teacher) SpringContext.getBean("teacher");
//        cacheProxy.decr("abcd");
        String bb = cacheProxy.get("aa", String.class);
        UserPo po = new UserPo();
        po.setAge(123);
        cacheProxy.put("user", po, 5, TimeUnit.DAYS);
        System.out.println(bb);
        return teacher.getName();
    }
}