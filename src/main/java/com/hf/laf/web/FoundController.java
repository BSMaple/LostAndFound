package com.hf.laf.web;


import com.hf.laf.dto.PaginationDto;
import com.hf.laf.entity.FoundRegister;
import com.hf.laf.service.FoundRegisterService;
import com.sun.istack.internal.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/found")
public class FoundController {

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

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Object add(FoundRegister record) {
        return foundRegisterService.addRecord(record);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Object delete(Integer foundId) {
        return foundRegisterService.deleteRecord(foundId);
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public Object update(FoundRegister record) {
        return foundRegisterService.updateRecord(record);
    }


    @RequestMapping("/selectpagination")
    @ResponseBody
    public Object selectpagination(@RequestParam(defaultValue = "10") int limit, @RequestParam(defaultValue = "0")  int offset) {
        PaginationDto pag = new PaginationDto();
        pag.setTotal(foundRegisterService.count());
        pag.setRows(foundRegisterService.selectPaginationRecord(limit,offset));

        return pag;

    }

    /**
     * 拾物列表页跳转controller
     * @return 页面文件名
     */
    @RequestMapping("/list")
    public String list() {
        return "foundList";

    }

    /**
     * 新增拾物跳转controller
     * @return 页面文件名
     */
    @RequestMapping("/add")
    public String newItem() {
        return "newFoundItem";
    }
}
