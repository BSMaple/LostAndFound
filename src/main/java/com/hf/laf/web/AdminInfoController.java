package com.hf.laf.web;

import com.hf.laf.service.AdminInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
@RequestMapping("/admin")
public class AdminInfoController {

    @Autowired
    AdminInfoService adminInfoService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)

    public Object select(String username, String password, HttpSession session) {

        if (username == null || password == null) return "loginError";

        HashMap<String, String> adminInfo = adminInfoService.queryByUsername(username);
        if (adminInfo.get("password").equals(password)) {
            session.setAttribute("isadmin", "666");
            return "foundList";
        }
        return "loginError";

    }

    @RequestMapping("/login")
    public String login() {
        return "adminLogin";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)

    public Object select(HttpSession session) {
        session.setAttribute("isadmin", null);
        return "foundList";


    }


}
