package com.hf.laf.service.serviceimpl;

import com.hf.laf.dao.AdminInfoDao;
import com.hf.laf.service.AdminInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class AdminInfoServiceImpl implements AdminInfoService {

    @Autowired
    AdminInfoDao adminInfoDao;
    public HashMap queryByUsername(String username) {
        return adminInfoDao.queryByUsername(username);
    }

}
