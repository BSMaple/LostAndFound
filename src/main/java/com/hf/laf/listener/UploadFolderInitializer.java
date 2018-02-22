package com.hf.laf.listener;

import com.hf.laf.configs.PathConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.util.ResourceUtils;
import util.FileUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Hzldex on 2018/2/22.
 */
public class UploadFolderInitializer implements ApplicationListener<ContextRefreshedEvent> {



    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        ApplicationContext applicationContext = contextRefreshedEvent.getApplicationContext();
        PathConfig pathConfig = applicationContext.getBean(PathConfig.class);


        File folder = new File(pathConfig.getFoundPicPath());

        if (!folder.exists()) {
            folder.mkdirs();
            //获取跟目录
            File path = null;
            try {
                path = new File(ResourceUtils.getURL("classpath:").getPath());
                if (!path.exists()) {
                    path = new File("");
                }

                File initPic = new File(path.getAbsolutePath(), "static/img/empty.jpg");

                FileInputStream fileInputStream = new FileInputStream(initPic);
                FileOutputStream fileOutputStream = new FileOutputStream(new File(folder, "empty.jpg"));

                FileUtil.streamCopy(fileOutputStream, fileInputStream);

                fileInputStream.close();
                fileOutputStream.close();
            } catch (IOException e) {
                Logger.getAnonymousLogger().log(Level.ALL,"上传文件夹初始化失败",e);
            }

        }


    }
}
