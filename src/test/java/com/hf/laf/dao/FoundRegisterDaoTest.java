package com.hf.laf.dao;

import com.hf.laf.entity.FoundRegister;
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
        foundRegisterDao.addRecord(foundRegistertest);
    }

    @Test
    public void updateRecord() {
        FoundRegister foundRegistertextu = new FoundRegister();
        foundRegistertextu.setFoundName("校卡");
        foundRegistertextu.setFoundPlace("England");
        foundRegistertextu.setFoundTime(new Date(2018,6,6));
        foundRegistertextu.setFoundDescribe("blue");
        foundRegistertextu.setFoundPeople("吴二凡");
        foundRegistertextu.setFoundTelephoneNumber("1008600");
        foundRegistertextu.setFoundId(4);

        foundRegisterDao.updateRecord(foundRegistertextu);

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