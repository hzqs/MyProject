package com.myproject.dao.impi;

import com.myproject.dao.RoomDao;
import com.myproject.entity.Room;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hzq on 2017/11/9.
 */
@Repository("roomDao")
public class RoomDaoimpi extends BaseDao implements RoomDao{


    //添加宿舍
    @Override
    public boolean addRoom(Room room) {
        getSession().save(room);
        return true;
    }

    //查询宿舍
    @Override
    public List findRoomList(String sql) {
        return getSession().createQuery(sql).list();
    }

    //查询出宿舍的详细信息（主页）
    @Override
    public List findRoomInfo(String sql) {
        return getSession().createQuery(sql).list();
    }

    //找出宿舍的学生姓名
    @Override
    public List findStuName(String sql) {
        return getSession().createQuery(sql).list();
    }




}
