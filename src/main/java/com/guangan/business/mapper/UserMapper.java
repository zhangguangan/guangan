package com.guangan.business.mapper;

import com.guangan.po.UserPo;

import java.util.List;

public interface UserMapper {
    List<UserPo> getAll();

    UserPo getOne(Long id);

    void insert(UserPo user);

    void update(UserPo user);

    void delete(Long id);
}
