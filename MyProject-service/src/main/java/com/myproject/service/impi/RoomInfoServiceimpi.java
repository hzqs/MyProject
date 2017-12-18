package com.myproject.service.impi;

import com.myproject.dao.RoomInfoDao;
import com.myproject.entity.RoomPubInfo;
import com.myproject.service.RoomInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by hzq on 2017/11/21.
 */
@Service("roominfoService")
@Transactional(propagation = Propagation.REQUIRED)
public class RoomInfoServiceimpi implements RoomInfoService {

    @Resource(name="roominfoDao")
     private RoomInfoDao roomInfoDao;

    @Override
    public boolean addRoomInfo(RoomPubInfo roomPubInfo) {
        return roomInfoDao.addRoomInfo(roomPubInfo);
    }

    @Override
    public List findRoomInfo() {
        return roomInfoDao.findRoomInfo("from RoomPubInfo");
    }



    //删除一个
    @Override
    public boolean deleteRoomInfo(RoomPubInfo roomPubInfo) {
        return roomInfoDao.deleteRoomInfo(roomPubInfo);
    }



    public void setRoomInfoDao(RoomInfoDao roomInfoDao) {
        this.roomInfoDao = roomInfoDao;
    }
}
