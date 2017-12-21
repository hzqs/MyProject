package com.myproject.dao.impi;

import com.myproject.dao.UserDao;
import com.myproject.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hzq on 2017/11/8.
 */
@Repository("userDao")
public class UserDaoimpi extends BaseDao implements UserDao{


    //查询用户
    @Override
    public List findUser(String sql) {
        return getSession().createQuery(sql).list();
    }

    @Override
    public boolean addUser(User user) {
        getSession().save(user);
        return true;
    }


}
