package com.myproject.dao.impi;

import com.myproject.dao.StuDao;
import com.myproject.entity.Stu;
import org.springframework.stereotype.Repository;

/**
 * Created by hzq on 2017/11/10.
 */
@Repository("stuDao")
public class StuDaoimpi extends BaseDao implements StuDao {

    //添加学生
    @Override
    public boolean addStu(Stu stu) {
         getSession().save(stu);
        return true;
    }







}
