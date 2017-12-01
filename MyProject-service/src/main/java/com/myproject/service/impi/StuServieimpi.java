package com.myproject.service.impi;

import com.myproject.dao.StuDao;
import com.myproject.entity.Stu;
import com.myproject.service.StuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by hzq on 2017/11/10.
 */
@Service("stuService")
@Transactional(propagation = Propagation.REQUIRED)
public class StuServieimpi implements StuService{


    @Resource(name="stuDao")
    private StuDao stuDao;
    //添加学生
    @Override
    public boolean addStu(Stu stu) {
        return stuDao.addStu(stu);
    }

    //
    public void setStuDao(StuDao stuDao) {
        this.stuDao = stuDao;
    }
}
