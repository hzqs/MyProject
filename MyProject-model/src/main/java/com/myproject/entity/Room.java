package com.myproject.entity;

import javax.persistence.*;

/**
 * Created by hzq on 2017/11/9.
 * 宿舍类
 */
@Entity
@Table(name="my_room")
public class Room {

    private int rno;
    private String rname;
    private String rpay;//宿舍费用

     //与宿管多对一
    private Manager manager;

    public Room() {

    }

    public Room(int rno, String rname, String rpay) {
        this.rno = rno;
        this.rname = rname;
        this.rpay = rpay;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getRno() {
        return rno;
    }

    public void setRno(int rno) {
        this.rno = rno;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getRpay() {
        return rpay;
    }

    public void setRpay(String rpay) {
        this.rpay = rpay;
    }
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.MERGE},fetch = FetchType.EAGER)
    @JoinColumn(name="rmno")
    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}
