package com.myproject.dao;

import com.myproject.entity.User;

import java.util.List;

/**
 * Created by hzq on 2017/11/6.
 */
public interface UserDao {

    //查询用户
    public List findUser(String sql);

    //注册
    public boolean addUser(User user);


}
