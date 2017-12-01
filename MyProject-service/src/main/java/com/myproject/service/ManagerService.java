package com.myproject.service;

import com.myproject.entity.Manager;

import java.util.List;

/**
 * Created by hzq on 2017/11/8.
 */
public interface ManagerService {

    //添加宿管
    public boolean addManager(Manager manager);

    //查询宿管
    public List findManagerList();

    //根据Id查询出宿管
    public Manager findManagerListById(Manager manager);
    //修改宿管
    public boolean updateManger(Manager manager);
    //删除宿管
    public boolean deleteManager(Manager manager);

}
