package com.hf.laf.service;

import com.hf.laf.entity.FoundRegister;
import org.springframework.stereotype.Service;

import java.util.List;


public interface FoundRegisterService {

    List selectpagination(int limit,int offset);

    FoundRegister selectFoundRegisterById(long foundId);

    int addRecord(FoundRegister record);

    int deleteRecord(long foundId);

    int updateRecord(FoundRegister record);

}
