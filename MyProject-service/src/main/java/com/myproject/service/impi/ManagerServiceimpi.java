package com.myproject.service.impi;

import com.myproject.dao.ManagerDao;
import com.myproject.entity.Manager;
import com.myproject.service.ManagerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by hzq on 2017/11/8.
 */
@Service("managerService")
@Transactional(propagation = Propagation.REQUIRED)
public class ManagerServiceimpi implements ManagerService{

    @Resource(name="managerDao")
    private ManagerDao managerDao;

    //添加宿管
    @Override
    public boolean addManager(Manager manager) {
        return managerDao.addManager(manager);
    }

    //查询宿管
    @Override
    public List findManagerList() {
        return managerDao.findManagerList("from Manager");
    }

    //根据Id查询宿管
    @Override
    public Manager findManagerListById(Manager manager) {
        return managerDao.findManagerListById(manager);
    }

    //修改宿管
    @Override
    public boolean updateManger(Manager manager) {
        return managerDao.updateManager(manager);
    }

    //删除宿管
    @Override
    public boolean deleteManager(Manager manager) {
        return managerDao.deleteManger(manager);
    }


    //
    public void setManagerDao(ManagerDao managerDao) {
        this.managerDao = managerDao;
    }
}
