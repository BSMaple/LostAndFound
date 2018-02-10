package com.hf.laf.web;


import com.hf.laf.entity.FoundRegister;
import com.hf.laf.service.FoundRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class TestController {

    @Autowired
    FoundRegisterService foundRegisterService;


    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/helloDeal")
    @ResponseBody
    public String dealHello(String username, String password) {
        return "用户名:" + username + "密码：" + password;
    }
    @RequestMapping("/select")
    @ResponseBody
    public Object select(Integer foundId) {
        return foundRegisterService.selectFoundRegisterById(foundId);
    }

    @RequestMapping("/add")
    @ResponseBody
    public Object add(FoundRegister record) {
        return foundRegisterService.addRecord(record);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Object delete(Integer foundId) {
        return foundRegisterService.deleteRecord(foundId);
    }

    @RequestMapping("/update")
    @ResponseBody
    public Object update(FoundRegister record) {
        return foundRegisterService.updateRecord(record);
    }
}
