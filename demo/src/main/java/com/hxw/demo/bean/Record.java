package com.hxw.demo.bean;

import java.util.Date;

public class Record {
    String id;
    String name;
    String phoneNum;
    Date time;
    String detailed;

    public Record(String name, String phoneNum, Date time, String detailed) {
        this.name = name;
        this.phoneNum = phoneNum;
        this.time = time;
        this.detailed = detailed;
    }

    public Record() {
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }



    public String getDetailed() {
        return detailed;
    }

    public void setDetailed(String detailed) {
        this.detailed = detailed;
    }
}
