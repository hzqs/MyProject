package com.myproject.entity;

import javax.persistence.*;

/**
 * Created by hzq on 2017/11/8.
 * 宿管类
 */

@Entity
@Table(name="my_manager")
public class Manager {

    private int mno;
    private String mname;
    private String mtel;

    public Manager() {

    }

    public Manager(int mno, String mname, String mtel) {
        this.mno = mno;
        this.mname = mname;
        this.mtel = mtel;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getMno() {
        return mno;
    }

    public void setMno(int mno) {
        this.mno = mno;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMtel() {
        return mtel;
    }

    public void setMtel(String mtel) {
        this.mtel = mtel;
    }
}
