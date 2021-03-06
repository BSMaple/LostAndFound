package com.hf.laf.service.serviceimpl;

import com.hf.laf.dao.FoundRegisterDao;
import com.hf.laf.entity.FoundRegister;
import com.hf.laf.service.FoundRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoundRegisterServiceImpl implements FoundRegisterService {

    @Autowired
    FoundRegisterDao foundRegisterDao;

    public List selectPaginationRecord(int limit, int offset) {
        return foundRegisterDao.selectPagination(limit, offset);
    }

    public List selectReviewedPaginationRecord(int limit, int offset) {
        return foundRegisterDao.selectReviewedPagination(limit, offset);
    }

    public int addRecord(FoundRegister record) {
        return foundRegisterDao.addRecord(record);
    }

    public int deleteRecord(long foundId) {
        return foundRegisterDao.deleteRecord(foundId);
    }

    public int updateRecord(FoundRegister record) {
        return foundRegisterDao.updateRecord(record);
    }

    @Override
    public FoundRegister selectFoundRegisterById(long foundId) {
//        System.out.println("Id 为" + foundId + " 的失物信息被查询了");
        return foundRegisterDao.queryById(foundId);
    }

    @Override
    public FoundRegister selectFoundRegisterByIdNotAuth(long foundId) {
        return foundRegisterDao.queryByIdNotAuth(foundId);
    }

    @Override
    public int count() {
        return foundRegisterDao.count();
    }

    @Override
    public int countReviewed() {
        return foundRegisterDao.countReviewed();
    }

    @Override
    public int setReview(int hadReview, int foundId) {
        return foundRegisterDao.setReview(hadReview, foundId);
    }
}


