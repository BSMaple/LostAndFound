package com.hf.laf.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class
LostRegister {

    private Integer lostId;

    private String  lostName;

    private String  lostPlace;

    private Date lostTime;

    private String  lostDescribe;

    @JsonIgnore
    private String  lostPeople;

    @JsonIgnore
    private String  lostTelephoneNumber;

    private byte  lostSituation;

    private byte  lostInfoVisible;

    private String lostPic;

    public byte getLostInfoVisible() {
        return lostInfoVisible;
    }

    public void setLostInfoVisible(byte lostInfoVisible) {
        this.lostInfoVisible = lostInfoVisible;
    }

    public byte getLostSituation() {
        return lostSituation;
    }

    public void setLostSituation(byte lostSituation) {
        this.lostSituation = lostSituation;
    }

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
        return lostTime;
    }

    public void setLostTime(Date lostTime) {
        this.lostTime = lostTime;
    }

    public String getLostDescribe() {
        return lostDescribe;
    }

    public void setLostDescribe(String lostDescribe) {
        this.lostDescribe = lostDescribe;
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

    public String getLostPic() {
        return lostPic;
    }

    public void setLostPic(String lostPic) {
        this.lostPic = lostPic;
    }

    @Override
    public String toString() {
        return "LostRegister{" +
                "lostId=" + lostId +
                ", lostName='" + lostName + '\'' +
                ", lostPlace='" + lostPlace + '\'' +
                ", lostTime='" + lostTime + '\'' +
                ", lostDescribe='" + lostDescribe + '\'' +
                ", lostPeople='" + lostPeople + '\'' +
                ", lostTelephoneNumber='" + lostTelephoneNumber + '\'' +
                '}';
    }
}
