package com.myproject.dao;

import com.myproject.entity.Room;
import com.myproject.entity.Stu;

import java.util.List;

/**
 * Created by hzq on 2017/11/9.
 */
public interface RoomDao {
    //添加宿舍
    public boolean addRoom(Room room);
    //只查询宿舍
    public List findRoomList(String sql);
    //查询出宿舍的详细信息（主页）
    public List findRoomInfo(String sql);

    //详情查询出宿舍详细的人名
    public List findStuName(String sql);
    //根据Id查询出学生信息
    public Stu findStuById(Stu stu);
    //修改
    public boolean updateRoomStu(Stu stu);







}
