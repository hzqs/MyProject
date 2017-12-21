package com.myproject.service;

import com.myproject.entity.User;

import java.util.List;

/**
 * Created by hzq on 2017/11/8.
 */
public interface UserService {

    //查询用户
    public List findUserList(String uname,String upwd);

    //注册
    public boolean addUser(User user);


}
