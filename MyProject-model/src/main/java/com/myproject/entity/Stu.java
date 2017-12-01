package com.myproject.entity;

import javax.persistence.*;

/**
 * Created by hzq on 2017/10/30.
 */

@Entity
@Table(name="my_stu")
public class Stu {

    private int sno;
    private String sname;
    private String ssex;
    private String stel;
    private int status=0;//学生身份，0位普通成员，1为寝室长。

    //与宿舍多对一

    private Room room;


    public Stu() {

    }

    public Stu(int sno, String sname, String ssex, String stel, int status) {
        this.sno = sno;
        this.sname = sname;
        this.ssex = ssex;
        this.stel = stel;
        this.status = status;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public String getStel() {
        return stel;
    }

    public void setStel(String stel) {
        this.stel = stel;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name="srno")
    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
