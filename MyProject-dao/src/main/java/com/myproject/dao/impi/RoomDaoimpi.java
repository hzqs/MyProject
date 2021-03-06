package com.myproject.dao.impi;

import com.myproject.dao.RoomDao;
import com.myproject.entity.Room;
import com.myproject.entity.Stu;
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

    //根据Id查学生
    @Override
    public Stu findStuById(Stu stu) {
        return getSession().get(Stu.class,stu.getSno());
    }

    //根据
    @Override
    public boolean updateRoomStu(Stu stu) {
         getSession().update(stu);
         return true;
    }

    //根据Id查询出宿舍信息
    @Override
    public Room findRoomById(Room room) {
        return getSession().get(Room.class,room.getRno());
    }

    //修改宿舍信息
    @Override
    public boolean updateRoom(Room room) {
        getSession().update(room);
        return true;
    }
    //修改宿舍中的学生信息


}
