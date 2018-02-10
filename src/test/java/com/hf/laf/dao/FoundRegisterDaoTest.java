package com.hf.laf.dao;

import com.hf.laf.entity.FoundRegister;
import com.hf.laf.service.FoundRegisterService;
import com.hf.laf.service.serviceimpl.FoundRegisterServiceImpl;
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
public class FoundRegisterDaoTest {

    @Autowired
    private FoundRegisterDao foundRegisterDao;

    @Autowired
    private FoundRegisterService foundRegisterService;

    @Test
    public void addRecordTest() {
        FoundRegister foundRegistertest = new FoundRegister();
        foundRegistertest.setFoundName("校卡");
        foundRegistertest.setFoundPlace("china");
        foundRegistertest.setFoundTime(new Date(1997,12,12));
        foundRegistertest.setFoundDescribe("blue");
        foundRegistertest.setFoundPeople("吴八凡");
        foundRegistertest.setFoundTelephoneNumber("1008611");
        foundRegistertest.setFoundSituation((byte)1);
        foundRegistertest.setFoundInfoVisible((byte)1);
        foundRegistertest.setFoundPic("123.jpg");
        foundRegisterService.addRecord(foundRegistertest);
    }

    @Test
    public void updateRecord() {
        FoundRegister foundRegistertestu = new FoundRegister();
        foundRegistertestu.setFoundName("校卡");
        foundRegistertestu.setFoundPlace("England");
        foundRegistertestu.setFoundTime(new Date(2018,6,6));
        foundRegistertestu.setFoundDescribe("blue");
        foundRegistertestu.setFoundPeople("吴二凡");
        foundRegistertestu.setFoundTelephoneNumber("1008600");
        foundRegistertestu.setFoundSituation((byte)0);
        foundRegistertestu.setFoundInfoVisible((byte)1);
        foundRegistertestu.setFoundPic("123.jpg");
        foundRegistertestu.setFoundId(10);
        foundRegisterService.updateRecord(foundRegistertestu);

    }

    @Test
    public void queryById() {
        FoundRegister foundRegisterq = foundRegisterDao.queryById(4);
        System.out.println(foundRegisterq);

    }


    @Test
    public void deleteRecord() {
        foundRegisterDao.deleteRecord(4);
    }

    @Test
    public void foundinfo() {
      List list= foundRegisterDao.foundinfo(5);
        System.out.println(list);

    }
}