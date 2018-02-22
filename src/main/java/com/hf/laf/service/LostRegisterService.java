package com.hf.laf.service;

import com.hf.laf.entity.LostRegister;
import org.springframework.stereotype.Service;

import java.util.List;


public interface LostRegisterService {

    List selectPaginationRecord(int limit, int offset);

    LostRegister selectLostRegisterById(long lostId);

    int addRecord(LostRegister record);

    int deleteRecord(long lostId);

    int updateRecord(LostRegister record);

    int count();

}
