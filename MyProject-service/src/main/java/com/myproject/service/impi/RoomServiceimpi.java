package com.myproject.service.impi;

import com.myproject.dao.RoomDao;
import com.myproject.entity.Room;
import com.myproject.entity.Stu;
import com.myproject.service.RoomService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by hzq on 2017/11/9.
 */
@Service("roomService")
@Transactional(propagation = Propagation.REQUIRED)
public class RoomServiceimpi implements RoomService{
    //添加宿舍

    @Resource(name="roomDao")
    private RoomDao roomDao;

    //添加宿舍
    @Override
    public boolean addRoom(Room room) {
        return roomDao.addRoom(room);
    }

    //查询宿舍
    @Override
    public List findRoomList() {
        return roomDao.findRoomList("from Room");
    }

    //查询出宿舍详细信息（主页）
    @Override
    public List findRoomInfo() {
        return roomDao.findRoomInfo("select r.rno,r.rname,r.rpay,count(s.sname),m.mname from Stu s inner join s.room r left join r.manager m" +
                " group by r.rname order by r.rpay desc\n" );
    }

    //查询出宿舍的学生姓名
    @Override
    public List findStuName(Room room) {
        return roomDao.findStuName("select r.rname,s.sno,s.sname,s.stel,s.status from Stu s inner join s.room r where r.rno="+room.getRno());
    }

    //根据Id查询出学生
    @Override
    public Stu findStuById(Stu stu) {
        return roomDao.findStuById(stu);
    }

    //修改宿舍中的学生信息
    @Override
    public boolean updateRoomStu(Stu stu) {
        return roomDao.updateRoomStu(stu);
    }

    //根据ID查询出宿舍信息
    @Override
    public Room findRoomById(Room room) {
        return roomDao.findRoomById(room);
    }

    //修改宿舍信息
    @Override
    public boolean updateRoom(Room room) {
        return roomDao.updateRoom(room);
    }






//
    public void setRoomDao(RoomDao roomDao) {
        this.roomDao = roomDao;
    }

}
