package com.hf.laf.dao;


import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface AdminInfoDao {

    HashMap queryByUsername(String username);

}
