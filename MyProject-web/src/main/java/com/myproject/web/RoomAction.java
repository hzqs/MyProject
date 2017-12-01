package com.myproject.web;

import com.myproject.entity.Room;
import com.myproject.service.RoomService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by hzq on 2017/11/9.
 */

@Controller("roomAction")
@Scope("prototype")
public class RoomAction {

    private Room room;
    @Resource(name="roomService")
    private RoomService roomService;
    private int res;
    private List roomList;
    public String addRoom(){
        if(room.getRname()!=null&&room.getRname().length()>0) {
            if (roomService.addRoom(room)) {
                res = 1;
            } else {
                res = 2;
            }
        } else{
            res=3;
        }
        return "addRoom";
    }

    //查询宿舍
    public String  findRoomList(){
        roomList=roomService.findRoomList();

        return "findRoom";
    }


    public void setRoomService(RoomService roomService) {
        this.roomService = roomService;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public List getRoomList() {
        return roomList;
    }

    public void setRoomList(List roomList) {
        this.roomList = roomList;
    }
}
