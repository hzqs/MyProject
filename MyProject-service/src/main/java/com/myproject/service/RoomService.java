package com.myproject.service;

import com.myproject.entity.Room;
import com.myproject.entity.Stu;

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
     ///根据Id查询出学生
    public Stu findStuById(Stu stu);
    //修改宿舍中的学生信息
    public boolean updateRoomStu(Stu stu);
    //根据ID查询出宿舍信息
    public Room findRoomById(Room room);
    //修改宿舍信息
    public boolean updateRoom(Room room);



}
