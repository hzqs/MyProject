package com.myproject.web;

import com.myproject.entity.Manager;
import com.myproject.service.ManagerService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by hzq on 2017/11/8.
 */

@Controller("managerAction")
@Scope("prototype")
public class ManagerAction {

    private Manager manager;
    @Resource(name="managerService")
    private ManagerService managerService;
    private int res;
    private List magList;
    //添加宿管
    public String addManager(){
         if(manager.getMname()!=null&&manager.getMname().length()>0|manager.getMtel()!=null&&manager.getMtel().length()>0) {
             if (managerService.addManager(manager) && manager.getMname().length() > 0) {
                 res = 1;
             } else {
                 res = 2;
             }
         }else {
             res=3;
         }
         return "addManager";

    }


    //查询宿管
    public String findManagerList(){

        magList=managerService.findManagerList();

        return "findManager";
    }

     //根据Id查询出宿管
    public String findMangerById(){
        manager=managerService.findManagerListById(manager);
        return "toApdate";
    }


    //删除宿管
    public String deleteManager(){
            if (managerService.deleteManager(manager)) {
                res = 1;
            } else {
                res = 2;
            }


        return "deleteManager";
    }

    //修改宿管
    public String updateManager(){
        if(manager.getMname()!=null&&manager.getMname().length()>0) {
            if (managerService.updateManger(manager)) {
                res = 1;
            } else {
                res = 2;
            }
        }else{
            res=3;
        }
        return "updateManager";
    }



     //
    public void setManagerService(ManagerService managerService) {
        this.managerService = managerService;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public List getMagList() {
        return magList;
    }

    public void setMagList(List magList) {
        this.magList = magList;
    }
}
