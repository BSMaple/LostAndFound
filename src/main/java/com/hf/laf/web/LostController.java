package com.hf.laf.web;

import com.hf.laf.dto.PaginationDto;
import com.hf.laf.entity.LostRegister;
import com.hf.laf.service.LostRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import util.FileUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

    public String lostPicPath ;

    @Autowired
    LostRegisterService lostRegisterService;


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
    public Object select(Integer lostId) {
        return lostRegisterService.selectLostRegisterById(lostId);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Object add(LostRegister record, @RequestParam("file") MultipartFile file,
                      HttpServletRequest request) {


        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();
        /*System.out.println("fileName-->" + fileName);
        System.out.println("getContentType-->" + contentType);*/


        if(!file.isEmpty()){

            String filePath =lostPicPath;
            try {
                FileUtil.uploadFile(file.getBytes(), filePath, fileName);
            } catch (Exception e) {
                // TODO: handle exception
            }
            record.setLostPic(fileName);
        }
        return lostRegisterService.addRecord(record);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Object delete(Integer lostId,HttpSession session)
    {
        if (session.getAttribute("isadmin").equals(666) )
        {return lostRegisterService.deleteRecord(lostId);}
        return "PasswordError";
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public Object update(LostRegister record,HttpSession session)
    {
        if (session.getAttribute("isadmin").equals(666) ){
        return lostRegisterService.updateRecord(record);}
        return "PasswordError";
    }


    @RequestMapping("/selectpagination")
    @ResponseBody
    public Object selectpagination(@RequestParam(defaultValue = "10") int limit, @RequestParam(defaultValue = "0")  int offset) {
        PaginationDto pag = new PaginationDto();
        pag.setTotal(lostRegisterService.count());
        pag.setRows(lostRegisterService.selectPaginationRecord(limit,offset));

        return pag;

    }
}
