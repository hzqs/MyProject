package com.myproject.entity;

import javax.persistence.*;

/**
 * Created by hzq on 2017/11/21.
 *
 * 宿舍公告类
 */
@Entity
@Table(name="my_pubinfo")
public class RoomPubInfo {

    private int rno;
    private String rinfo;

    public RoomPubInfo() {

    }

    public RoomPubInfo(int rno, String rinfo) {
        this.rno = rno;
        this.rinfo = rinfo;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getRno() {
        return rno;
    }

    public void setRno(int rno) {
        this.rno = rno;
    }

    public String getRinfo() {
        return rinfo;
    }

    public void setRinfo(String rinfo) {
        this.rinfo = rinfo;
    }
}

