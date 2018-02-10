package com.hf.laf.dao;

import com.hf.laf.entity.LostRegister;
import org.apache.ibatis.annotations.Delete;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LostRegisterDaoTest {

    @Autowired
    private LostRegisterDao lostRegisterDao;

    @Test
    public void addRecordTest() {
        LostRegister lostRegistertest = new LostRegister();
        lostRegistertest.setLostName("校卡");
        lostRegistertest.setLostPlace("china");
        lostRegistertest.setLostTime(new Date(1997,12,12));
        lostRegistertest.setLostDescribe("blue");
        lostRegistertest.setLostPeople("吴一凡");
        lostRegistertest.setLostTelephoneNumber("1008611");


        lostRegisterDao.addRecord(lostRegistertest);
    }

    @Test
    public void updateRecord() {
        LostRegister lostRegistertextu = new LostRegister();
        lostRegistertextu.setLostName("校卡");
        lostRegistertextu.setLostPlace("England");
        lostRegistertextu.setLostTime(new Date(2018,1,1));
        lostRegistertextu.setLostDescribe("blue");
        lostRegistertextu.setLostPeople("吴二凡");
        lostRegistertextu.setLostTelephoneNumber("1008600");
        lostRegistertextu.setLostId(1);

        lostRegisterDao.updateRecord(lostRegistertextu);

    }

    @Test
    public void queryById() {
        LostRegister lostRegisterq = lostRegisterDao.queryById(2);
        System.out.println(lostRegisterq);

    }


    @Test
    public void deleteRecord() {
        lostRegisterDao.deleteRecord(1);
    }


}