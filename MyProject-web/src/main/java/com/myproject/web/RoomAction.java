package com.myproject.web;

import com.myproject.entity.Room;
import com.myproject.service.RoomService;
import com.opensymphony.xwork2.ActionContext;
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
    private List roomInfoList;
    private List stulistName;
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


    //查询宿舍的详细信息（主页）

    public String findRoomInfo(){
        roomInfoList=roomService.findRoomInfo();
        return "findRoomInfo";
    }
     //查询出宿舍的学生姓名
    public String findStuName(){
      stulistName=roomService.findStuName(room);
        ActionContext.getContext().getSession().put("stulistName",stulistName);
        return "stuName";

    }




    //
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

    public List getRoomInfoList() {
        return roomInfoList;
    }

    public void setRoomInfoList(List roomInfoList) {
        this.roomInfoList = roomInfoList;
    }


    public List getStulistName() {
        return stulistName;
    }

    public void setStulistName(List stulistName) {
        this.stulistName = stulistName;
    }
}
