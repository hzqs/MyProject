package com.myproject.dao.impi;

import com.myproject.dao.ManagerDao;
import com.myproject.entity.Manager;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hzq on 2017/11/8.
 */
@Repository("managerDao")
public class ManagerDaoimpi extends BaseDao implements ManagerDao{


    //添加宿管
    @Override
    public boolean addManager(Manager manager) {
       getSession().save(manager);
        return true;
    }

    //查询出宿管
    @Override
    public List findManagerList(String sql) {
        return getSession().createQuery(sql).list();
    }

    //根据Id查询出宿管
    @Override
    public Manager findManagerListById(Manager manager) {

        return getSession().get(Manager.class,manager.getMno());

    }

    //修改宿管
    @Override
    public boolean updateManager(Manager manager) {
         getSession().update(manager);
        return true;
    }

    @Override
    public boolean deleteManger(Manager manager) {
        getSession().delete(manager);
        return true;
    }


}
