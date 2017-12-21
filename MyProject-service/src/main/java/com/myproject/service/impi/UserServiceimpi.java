package com.myproject.service.impi;

import com.myproject.dao.UserDao;
import com.myproject.entity.User;
import com.myproject.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by hzq on 2017/11/8.
 */
@Service("userService")
@Transactional(propagation = Propagation.REQUIRED)

public class UserServiceimpi implements UserService{

    @Resource(name="userDao")
    private UserDao userDao;

    //查询用户
    @Override
    public List findUserList(String uname,String upwd) {

        return userDao.findUser("from User where uname='"+uname+"' and upwd='"+upwd+"'");

    }

    @Override
    public boolean addUser(User user) {
        return userDao.addUser(user);
    }


    //
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
