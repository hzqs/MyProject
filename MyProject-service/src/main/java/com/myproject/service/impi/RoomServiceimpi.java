package com.myproject.service.impi;

import com.myproject.dao.RoomDao;
import com.myproject.entity.Room;
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
        return roomDao.findRoomInfo("");
    }

    //
    public void setRoomDao(RoomDao roomDao) {
        this.roomDao = roomDao;
    }
}
