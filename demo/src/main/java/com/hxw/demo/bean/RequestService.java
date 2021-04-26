package com.hxw.demo.bean;

import com.fasterxml.jackson.annotation.JsonProperty;


public class RequestService {

    @JsonProperty("myPhoneNum")
    private String myPhoneNum;

    @JsonProperty("otherPhoneNum")
    private String otherPhoneNum;

    @JsonProperty("otherName")
    private String otherName;

    @JsonProperty("money")
    private int money;

    public String getMyPhoneNum() {
        return myPhoneNum;
    }

    public void setMyPhoneNum(String myPhoneNum) {
        this.myPhoneNum = myPhoneNum;
    }

    public String getOtherPhoneNum() {
        return otherPhoneNum;
    }

    public void setOtherPhoneNum(String otherPhoneNum) {
        this.otherPhoneNum = otherPhoneNum;
    }

    public String getOtherName() {
        return otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
