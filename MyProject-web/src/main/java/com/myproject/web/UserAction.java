package com.myproject.web;

import com.myproject.entity.User;
import com.myproject.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by hzq on 2017/11/8.
 */
@Controller("userAction")
@Scope("prototype")
public class UserAction {

    private User user;
    @Resource(name="userService")
    private UserService userService;

     //验证登录
    public String loginUser(){
        List list = userService.findUserList(user.getUname(), user.getUpwd());
        if (list != null && list.size() > 0) {
            ActionContext.getContext().getSession().put("uname",user.getUname());
        }else{
            return "error";
        }

        return "mains";

    }



    //
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
