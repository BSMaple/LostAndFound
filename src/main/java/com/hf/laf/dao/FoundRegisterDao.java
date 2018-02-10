package com.hf.laf.dao;

import com.hf.laf.entity.FoundRegister;
import org.apache.ibatis.annotations.Mapper;

import javax.validation.constraints.Digits;
import java.util.List;

@Mapper
public interface FoundRegisterDao {

    FoundRegister queryById(long foundId);

    int addRecord(FoundRegister record);

    int deleteRecord(long foundId);

    int updateRecord(FoundRegister record);

    List selectpagination(int limit,int offset);

    List foundinfo(long foundId);
}
