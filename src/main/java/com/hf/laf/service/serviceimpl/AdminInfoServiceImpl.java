package com.hf.laf.service.serviceimpl;

import com.hf.laf.dao.AdminInfoDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

public class AdminInfoServiceImpl {

    @Autowired
    AdminInfoDao adminInfoDao;
    public HashMap queryByUsername(String username) {
        return adminInfoDao.queryByUsername(username);
    }

}
