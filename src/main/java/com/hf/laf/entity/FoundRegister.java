package com.hf.laf.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class
FoundRegister {

    private Integer foundId;

    private String  foundName;

    private String  foundPlace;

    private Date foundTime;

    private String  foundDescribe;

    private String  foundPeople;

    private String  foundTelephoneNumber;

    private byte  foundSituation;

    private byte  foundInfoVisible;

    private String foundPic;

    private int hadReview;

    public byte getFoundInfoVisible() {
        return foundInfoVisible;
    }

    public void setFoundInfoVisible(byte foundInfoVisible) {
        this.foundInfoVisible = foundInfoVisible;
    }

    public byte getFoundSituation() {
        return foundSituation;
    }

    public void setFoundSituation(byte foundSituation) {
        this.foundSituation = foundSituation;
    }

    public Integer getFoundId() {
        return foundId;
    }

    public void setFoundId(Integer foundId) {
        this.foundId = foundId;
    }

    public String getFoundName() {
        return foundName;
    }

    public void setFoundName(String foundName) {
        this.foundName = foundName;
    }

    public String getFoundPlace() {
        return foundPlace;
    }

    public void setFoundPlace(String foundPlace) {
        this.foundPlace = foundPlace;
    }

    public Date getFoundTime() {
        return foundTime;
    }

    public void setFoundTime(Date foundTime) {
        this.foundTime = foundTime;
    }

    public String getFoundDescribe() {
        return foundDescribe;
    }

    public void setFoundDescribe(String foundDescribe) {
        this.foundDescribe = foundDescribe;
    }

    public String getFoundPeople() {
        return foundPeople;
    }

    public void setFoundPeople(String foundPeople) {
        this.foundPeople = foundPeople;
    }

    public String getFoundTelephoneNumber() {
        return foundTelephoneNumber;
    }

    public void setFoundTelephoneNumber(String foundTelephoneNumber) {
        this.foundTelephoneNumber = foundTelephoneNumber;
    }

    public String getFoundPic() {
        return foundPic;
    }

    public void setFoundPic(String foundPic) {
        this.foundPic = foundPic;
    }

    public int getHadReview() {
        return hadReview;
    }

    public void setHadReview(int hadReview) {
        this.hadReview = hadReview;
    }

    @Override
    public String toString() {
        return "FoundRegister{" +
                "foundId=" + foundId +
                ", foundName='" + foundName + '\'' +
                ", foundPlace='" + foundPlace + '\'' +
                ", foundTime='" + foundTime + '\'' +
                ", foundDescribe='" + foundDescribe + '\'' +
                ", foundPeople='" + foundPeople + '\'' +
                ", foundTelephoneNumber='" + foundTelephoneNumber + '\'' +
                '}';
    }
}
