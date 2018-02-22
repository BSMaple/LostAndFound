package com.hf.laf;

import com.hf.laf.listener.UploadFolderInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LafApplication {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(LafApplication.class);
		springApplication.addListeners(new UploadFolderInitializer());
		springApplication.run(args);


	}
}
