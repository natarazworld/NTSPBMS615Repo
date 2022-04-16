package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@SpringBootApplication
public class BootMvcProj16FileUploadingDownloading1Application {

	@Bean(name="multipartResolver")
	public CommonsMultipartResolver  createCMResolver() {
		  CommonsMultipartResolver resolver=new CommonsMultipartResolver();
		  resolver.setMaxUploadSizePerFile(50*1024*1024);
		  resolver.setMaxUploadSize(-1);  //all files togather how much size is allowed  -1 indicates no limit
		  return resolver;
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(BootMvcProj16FileUploadingDownloading1Application.class, args);
	}

}
