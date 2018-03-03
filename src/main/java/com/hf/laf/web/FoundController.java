package com.hf.laf.web;


import com.hf.laf.configs.PathConfig;
import com.hf.laf.dto.PaginationDto;
import com.hf.laf.entity.FoundRegister;
import com.hf.laf.service.FoundRegisterService;
import com.hf.laf.util.AdminTool;
import com.hf.laf.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.Date;

@Controller
@RequestMapping("/found")
public class FoundController {

    @Autowired
    FoundRegisterService foundRegisterService;
    @Autowired
    private PathConfig pathConfig;

    @RequestMapping("/select")
    @ResponseBody
    public Object select(Integer foundId, HttpSession session) {
        if (AdminTool.isAdmin(session)) {
            return foundRegisterService.selectFoundRegisterById(foundId);
        }
        return foundRegisterService.selectFoundRegisterByIdNotAuth(foundId);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object add(FoundRegister record, @RequestParam("picInput") MultipartFile file) {

        String fileName = String.valueOf(new Date().getTime());

        if (!file.isEmpty()) {

            String filePath = pathConfig.getFoundPicPath();
            try {
                FileUtil.uploadFile(file.getBytes(), filePath, fileName);
            } catch (Exception e) {
                // TODO: handle exception
            }
            record.setFoundPic(fileName);
        }
        if (foundRegisterService.addRecord(record) == 1) {
            return "foundList";
        } else return "addError";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public Object delete(Integer foundId, HttpSession session) {
        if (AdminTool.isAdmin(session)) {
            return foundRegisterService.deleteRecord(foundId);
        }
        return "permissionError";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Object update(FoundRegister record, HttpSession session) {
        if (AdminTool.isAdmin(session)) {
            return foundRegisterService.updateRecord(record);
        }
        return "permissionError";
    }

    @RequestMapping(value = "/setReview", method = RequestMethod.POST)
    @ResponseBody
    public Object update(Integer foundId, Integer hadReview, HttpSession session) {
        if (AdminTool.isAdmin(session)) {
            return foundRegisterService.setReview(hadReview, foundId);
        }
        return "permissionError";
    }


    @RequestMapping("/selectPagination")
    @ResponseBody
    public Object selectPagination(@RequestParam(defaultValue = "10") int limit, @RequestParam(defaultValue = "0") int offset, HttpSession session) {
        PaginationDto pag = new PaginationDto();

        if(AdminTool.isAdmin(session)){
            pag.setTotal(foundRegisterService.count());
            pag.setRows(foundRegisterService.selectPaginationRecord(limit, offset));
        }else{
            pag.setTotal(foundRegisterService.countReviewed());
            pag.setRows(foundRegisterService.selectReviewedPaginationRecord(limit, offset));
        }


        return pag;

    }

    @RequestMapping("/pics/{fileName:[a-zA-Z0-9\\\\.]+}")
    public void getPic(@PathVariable String fileName, HttpServletResponse response) {
        File file = new File(pathConfig.getFoundPicPath());
        try {
            FileInputStream fileInputStream = new FileInputStream(file + File.separator + fileName);
            OutputStream out = response.getOutputStream();

            FileUtil.streamCopy(out, fileInputStream);

            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 拾物列表页
     *
     * @return 列表页文件名
     */
    @RequestMapping("/list")

    public String list() {
        return "foundList";

    }

    /**
     * 新拾物发表页
     *
     * @return 发表页文件名
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String newItem() {
        return "newFoundItem";
    }

    /**
     *
     */
    @RequestMapping(value = "/detail")
    public String detailPage() {
        return "foundDetail";
    }

}
