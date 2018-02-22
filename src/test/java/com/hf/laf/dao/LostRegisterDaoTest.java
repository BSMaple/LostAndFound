package com.hf.laf.dao;

import com.hf.laf.entity.LostRegister;
import com.hf.laf.service.LostRegisterService;
import com.hf.laf.service.serviceimpl.LostRegisterServiceImpl;
import org.apache.ibatis.annotations.Delete;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LostRegisterDaoTest {

    @Autowired
    private LostRegisterDao lostRegisterDao;

    @Autowired
    private LostRegisterService lostRegisterService;

    @Test
    public void addRecordTest() {
        LostRegister lostRegistertest = new LostRegister();
        lostRegistertest.setLostName("校卡");
        lostRegistertest.setLostPlace("china");
        lostRegistertest.setLostTime(new Date(1997,12,12));
        lostRegistertest.setLostDescribe("blue");
        lostRegistertest.setLostPeople("吴八凡");
        lostRegistertest.setLostTelephoneNumber("1008611");
        lostRegistertest.setLostSituation((byte)1);
        lostRegistertest.setLostInfoVisible((byte)1);
        lostRegistertest.setLostPic("123.jpg");
        lostRegisterService.addRecord(lostRegistertest);
    }

    @Test
    public void updateRecord() {
        LostRegister lostRegistertestu = new LostRegister();
        lostRegistertestu.setLostName("校卡");
        lostRegistertestu.setLostPlace("England");
        lostRegistertestu.setLostTime(new Date(2018,6,6));
        lostRegistertestu.setLostDescribe("blue");
        lostRegistertestu.setLostPeople("吴二凡");
        lostRegistertestu.setLostTelephoneNumber("1008600");
        lostRegistertestu.setLostSituation((byte)0);
        lostRegistertestu.setLostInfoVisible((byte)1);
        lostRegistertestu.setLostPic("123.jpg");
        lostRegistertestu.setLostId(10);
        lostRegisterService.updateRecord(lostRegistertestu);

    }

    @Test
    public void queryById() {
        LostRegister lostRegisterq = lostRegisterDao.queryById(4);
        System.out.println(lostRegisterq);

    }


    @Test
    public void deleteRecord() {
        lostRegisterDao.deleteRecord(4);
    }

    @Test
    public void lostinfo() {
        List list= lostRegisterDao.lostinfo(5);
        System.out.println(list);

    }
}