package com.myproject.web;

import com.myproject.entity.RoomPubInfo;
import com.myproject.service.RoomInfoService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by hzq on 2017/11/21.
 */
@Controller("roominfoAction")
@Scope("prototype")
public class RoomInfoAction {

    private RoomPubInfo roomPubInfo;
    @Resource(name="roominfoService")
    private RoomInfoService roomInfoService;
    private int res;
    private List roominfolist;

    //添加公告
    public String addRoomInfo(){
        if(roomPubInfo.getRinfo()!=null&&roomPubInfo.getRinfo().length()>0) {
            if (roomInfoService.addRoomInfo(roomPubInfo)) {
                res = 1;
            } else {
                res = 2;
            }
        }else{
            res=3;
        }
        return "addroominfo";
    }


    //查询公告
    public String findRoomInfo(){
        roominfolist=roomInfoService.findRoomInfo();
        return "findRoomInfo";

    }



    //删除公告
    public String deleteRoomInfo(){
        if(roomInfoService.deleteRoomInfo(roomPubInfo)){
            res=1;
        }else {
            res=2;
        }
        return "deleteRoomInfo";
    }


    public RoomPubInfo getRoomPubInfo() {
        return roomPubInfo;
    }

    public void setRoomPubInfo(RoomPubInfo roomPubInfo) {
        this.roomPubInfo = roomPubInfo;
    }

    public void setRoomInfoService(RoomInfoService roomInfoService) {
        this.roomInfoService = roomInfoService;
    }

    public int getRess() {
        return res;
    }

    public void setRess(int ress) {
        this.res = ress;
    }

    public List getRoominfolist() {
        return roominfolist;
    }

    public void setRoominfolist(List roominfolist) {
        this.roominfolist = roominfolist;
    }

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }
}
