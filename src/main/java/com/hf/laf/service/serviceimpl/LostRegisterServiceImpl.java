package com.hf.laf.service.serviceimpl;

import com.hf.laf.dao.LostRegisterDao;
import com.hf.laf.entity.LostRegister;
import com.hf.laf.service.LostRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LostRegisterServiceImpl implements LostRegisterService {

    @Autowired
    LostRegisterDao lostRegisterDao;

    public List selectPaginationRecord(int limit, int offset){
        return lostRegisterDao.selectpagination(limit,offset);
    }

    public int addRecord(LostRegister record){
        return lostRegisterDao.addRecord(record);
    }

    public int deleteRecord(long lostId){
        return lostRegisterDao.deleteRecord(lostId);
    }

    public int updateRecord(LostRegister record){
        return lostRegisterDao.updateRecord(record);
    }

    @Override
    public LostRegister selectLostRegisterById(long lostId) {
        System.out.println("Id 为" + lostId + " 的失物信息被查询了");
        return lostRegisterDao.queryById(lostId);
    }

    @Override
    public int count() {
        return lostRegisterDao.count();
    }
}


