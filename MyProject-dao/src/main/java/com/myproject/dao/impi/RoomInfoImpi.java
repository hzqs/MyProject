package com.myproject.dao.impi;

import com.myproject.dao.RoomInfoDao;
import com.myproject.entity.RoomPubInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hzq on 2017/11/21.
 */
@Repository("roominfoDao")
public class RoomInfoImpi extends  BaseDao implements RoomInfoDao {


    //添加公告
    @Override
    public boolean addRoomInfo(RoomPubInfo roomPubInfo) {
        getSession().save(roomPubInfo);
        return true;
    }

    //发布公告
    @Override
    public List findRoomInfo(String sql) {
        return getSession().createQuery(sql).list();
    }

    //删除公告
    @Override
    public boolean deleteRoomInfo(RoomPubInfo roomPubInfo) {
        getSession().delete(roomPubInfo);
        return true;
    }
}
