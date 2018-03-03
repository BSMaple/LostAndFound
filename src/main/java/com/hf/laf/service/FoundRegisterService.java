package com.hf.laf.service;

import com.hf.laf.entity.FoundRegister;
import org.springframework.stereotype.Service;

import java.util.List;


public interface FoundRegisterService {

    List selectPaginationRecord(int limit, int offset);

    List selectReviewedPaginationRecord(int limit, int offset);

    FoundRegister selectFoundRegisterById(long foundId);

    FoundRegister selectFoundRegisterByIdNotAuth(long foundId);

    int addRecord(FoundRegister record);

    int deleteRecord(long foundId);

    int updateRecord(FoundRegister record);

    int setReview(int hadReview,int foundId);

    int count();

    int countReviewed();

}
