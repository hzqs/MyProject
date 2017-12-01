package com.myproject.web;

import com.myproject.entity.Stu;
import com.myproject.service.StuService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Created by hzq on 2017/10/30.
 */
@Controller("stuAction")
@Scope("prototype")
public class StuAction {

    private Stu stu;
    @Resource(name="stuService")
    private StuService stuService;
    private int message;
    //添加学生
    public String addStu(){
        if(stu.getSname()!=null&&stu.getSname().length()>0){
              if(stuService.addStu(stu)){
                  message=1;
              }else{
                  message=2;
              }
           }else{
            message=3;
        }
        return "addStu";
    }



    //
    public void setStuService(StuService stuService) {
        this.stuService = stuService;
    }

    public Stu getStu() {
        return stu;
    }

    public void setStu(Stu stu) {
        this.stu = stu;
    }

    public int getMessage() {
        return message;
    }

    public void setMessage(int message) {
        this.message = message;
    }
}

