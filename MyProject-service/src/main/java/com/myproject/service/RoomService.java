package com.myproject.service;

import com.myproject.entity.Room;

import java.util.List;

/**
 * Created by hzq on 2017/11/9.
 */
public interface RoomService {
    //添加宿舍
    public boolean addRoom(Room room);
    //查询宿舍
    public List findRoomList();
    //查询出宿舍详细信息(主页)
    public List findRoomInfo();
    //查询出详细的宿舍学生姓名；
    public List findStuName(Room room);





}
