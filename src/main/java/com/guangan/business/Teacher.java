package com.guangan.business;

import com.alibaba.fastjson.JSONObject;
import com.guangan.business.mapper.UserMapper;
import com.guangan.po.UserPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class Teacher {
    @Autowired
    UserMapper userMapper;
    @Transactional
    public String getName() {
        List<UserPo> list = userMapper.getAll();
        System.out.println(JSONObject.toJSONString(list));
        return "aaa";

    }
}
