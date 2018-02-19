package com.hf.laf.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 失物招领控制器
 * Created by Hzldex on 2018/2/19.
 */
@Controller
@RequestMapping("/lost")
public class LostController {

    /**
     * 失物招领列表页跳转controller
     * @return 页面文件名
     */
    @RequestMapping("/list")
    public String list() {
        return "lostList";

    }
}
