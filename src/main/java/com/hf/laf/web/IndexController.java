package com.hf.laf.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Hzldex on 2018/3/3.
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    public String index(){
        return "foundList";
    }
}
