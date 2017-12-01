package com.myproject.dao;

import com.myproject.entity.Manager;

import java.util.List;

/**
 * Created by hzq on 2017/11/8.
 */
public interface ManagerDao {

    //添加宿管
    public boolean addManager(Manager manager);
     //查询宿管
    public List findManagerList(String sql);
    //根据Id查询出宿管
    public Manager findManagerListById(Manager manager);
    //修改宿管
    public boolean updateManager(Manager manager);
    //删除宿管
    public boolean deleteManger(Manager manager);

}
