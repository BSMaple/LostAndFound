package com.hf.laf.web;

import com.hf.laf.service.AdminInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

public class AdminInfoController {

    @Autowired
    AdminInfoService adminInfoService;

    @RequestMapping("/queryByUsername")
    @ResponseBody

    public Object select(String username,String password,HttpSession session) {

        HashMap<String,String> adminInfo = adminInfoService.queryByUsername(username);
        if(adminInfo.get("password").equals(password)){
            session.setAttribute("isadmin", "666");
            return "foundList";
        }
        return "PasswordError";

    }



}
