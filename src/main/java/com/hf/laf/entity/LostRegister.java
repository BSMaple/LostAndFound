package com.hf.laf.entity;

import java.util.Date;

public class LostRegister {

    private  Integer lostId;

    private  String  lostName;

    private  String  lostPlace;

    private Date lost_time;

    private  String  lostDscrible;

    private  String  lostPeople;

    private  String  lostTelephoneNumber;

    public Integer getLostId() {
        return lostId;
    }

    public void setLostId(Integer lostId) {
        this.lostId = lostId;
    }

    public String getLostName() {
        return lostName;
    }

    public void setLostName(String lostName) {
        this.lostName = lostName;
    }

    public String getLostPlace() {
        return lostPlace;
    }

    public void setLostPlace(String lostPlace) {
        this.lostPlace = lostPlace;
    }

    public Date getLostTime() {
        return lost_time;
    }

    public void setLostTime(Date lost_time) {
        this.lost_time = lost_time;
    }

    public String getLostDescribe() {
        return lostDscrible;
    }

    public void setLostDescribe(String lostDscrible) {
        this.lostDscrible = lostDscrible;
    }

    public String getLostPeople() {
        return lostPeople;
    }

    public void setLostPeople(String lostPeople) {
        this.lostPeople = lostPeople;
    }

    public String getLostTelephoneNumber() {
        return lostTelephoneNumber;
    }

    public void setLostTelephoneNumber(String lostTelephoneNumber) {
        this.lostTelephoneNumber = lostTelephoneNumber;
    }

    @Override
    public String toString() {
        return "LostRegister{" +
                "lostId=" + lostId +
                ", lostName='" + lostName + '\'' +
                ", lostPlace='" + lostPlace + '\'' +
                ", lost_time='" + lost_time + '\'' +
                ", lostDscrible='" + lostDscrible + '\'' +
                ", lostPeople='" + lostPeople + '\'' +
                ", lostTelephoneNumber='" + lostTelephoneNumber + '\'' +
                '}';
    }
}
