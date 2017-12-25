package com.myproject.service;

import com.myproject.entity.Room;
import com.myproject.entity.RoomPubInfo;

import java.util.List;

/**
 * Created by hzq on 2017/11/21.
 */
public interface RoomInfoService {

    //添加公告
    public boolean addRoomInfo(RoomPubInfo roomPubInfo);
    //查询公告
    public List findRoomInfo();
    //删除公告
    public boolean deleteRoomInfo(int[] rno);

}
