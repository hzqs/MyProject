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

    //添加
    @Override
    public boolean addRoomInfo(RoomPubInfo roomPubInfo) {
        return roomInfoDao.addRoomInfo(roomPubInfo);
    }

    //查询
    @Override
    public List findRoomInfo() {
        return roomInfoDao.findRoomInfo("from RoomPubInfo");
    }

    //批量删除
    @Override
    public boolean deleteRoomInfo(int[] rno) {
        if(rno!=null&&rno.length>0){
            for(int rnos:rno){
                RoomPubInfo roomPubInfo=new RoomPubInfo();
                roomPubInfo.setRno(rnos);
                roomInfoDao.deleteRoomInfo(roomPubInfo);
            }
            return true;
        }
        return false;
    }


   //
    public void setRoomInfoDao(RoomInfoDao roomInfoDao) {
        this.roomInfoDao = roomInfoDao;
    }
}
