package com.hf.laf.dao;

import com.hf.laf.entity.LostRegister;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LostRegisterDao {

    LostRegister queryById(long lostId);

    int addRecord(LostRegister record);

    int deleteRecord(long lostId);

    int updateRecord(LostRegister record);

    List selectpagination(int limit, int offset);

}
