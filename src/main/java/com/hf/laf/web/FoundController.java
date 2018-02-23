package com.hf.laf.web;


import com.hf.laf.configs.PathConfig;
import com.hf.laf.dto.PaginationDto;
import com.hf.laf.entity.FoundRegister;
import com.hf.laf.service.FoundRegisterService;
import com.sun.istack.internal.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import util.FileUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;

@Controller
@RequestMapping("/found")
public class FoundController {

    @Autowired
    private PathConfig pathConfig;

    @Autowired
    FoundRegisterService foundRegisterService;

    @RequestMapping("/select")
    @ResponseBody
    public Object select(Integer foundId) {
        return foundRegisterService.selectFoundRegisterById(foundId);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object add(FoundRegister record,@RequestParam("picInput") MultipartFile file) {


        String fileName = file.getOriginalFilename();
        /*System.out.println("fileName-->" + fileName);
        System.out.println("getContentType-->" + contentType);*/


        if(!file.isEmpty()){

            String filePath =pathConfig.getFoundPicPath();
            try {
                FileUtil.uploadFile(file.getBytes(), filePath, fileName);
            } catch (Exception e) {
                // TODO: handle exception
            }
            record.setFoundPic(fileName);
        }
        if (foundRegisterService.addRecord(record) == 1){
            return "foundList";
        }
        else return ("ERROR");
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public Object delete(Integer foundId,HttpSession session) {
        if (session.getAttribute("isadmin").equals(666) ){
        return foundRegisterService.deleteRecord(foundId);
        }
        return "PasswordError";
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public Object update(FoundRegister record,HttpSession session) {
        if (session.getAttribute("isadmin").equals(666) ){
        return foundRegisterService.updateRecord(record);
    }
        return  "PasswordError";
    }



    @RequestMapping("/selectpagination")
    @ResponseBody
    public Object selectpagination(@RequestParam(defaultValue = "10") int limit, @RequestParam(defaultValue = "0")  int offset) {
        PaginationDto pag = new PaginationDto();
        pag.setTotal(foundRegisterService.count());
        pag.setRows(foundRegisterService.selectPaginationRecord(limit,offset));

        return pag;

    }

    @RequestMapping("/pics/{fileName:[a-zA-Z0-9\\\\.]+}")
    public void getPic(@PathVariable String fileName, HttpServletResponse response){
        File file = new File(pathConfig.getFoundPicPath());
        try {
            FileInputStream fileInputStream = new FileInputStream(file + File.separator +  fileName);
            OutputStream out = response.getOutputStream();

            FileUtil.streamCopy(out,fileInputStream);

            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 拾物列表页
     * @return 列表页文件名
     */
    @RequestMapping("/list")

    public String list() {
        return "foundList";

    }

    /**
     * 新拾物发表页
     * @return 发表页文件名
     */
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String newItem(){
        return "newFoundItem";
    }


}
