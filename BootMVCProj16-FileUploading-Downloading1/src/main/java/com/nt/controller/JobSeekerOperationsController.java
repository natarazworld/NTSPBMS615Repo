package com.nt.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.nt.entity.JobSeekerInfo;
import com.nt.model.JobSeekerData;
import com.nt.service.IJobSeekerMgmtService;


@Controller
public class JobSeekerOperationsController {
	@Autowired
	private IJobSeekerMgmtService service;
	
	@GetMapping("/")
	public  String showHomePage() {
		System.out.println("JobSeekerOperationsController.showHomePage()");
		return  "welcome";
	}
	
	@GetMapping("/register")
	public   String  showJSRegistrationForm(@ModelAttribute("js") JobSeekerData jsData) {
		//return LVN
		return "jobseeker_register";
	}
	
	
	@Autowired
	private Environment env;
	
	@PostMapping("/register")
	public   String  registerJSByUploadingFiles(@ModelAttribute("js") JobSeekerData jsData,
			                                                                  Map<String,Object> map)throws Exception {
		//get Upload folder location from properties file
		String storeLocation=env.getRequiredProperty("upload.store");
		// if that not avaiable then create it
		File file=new File(storeLocation);
		 if(!file.exists())
			  file.mkdir();
		 
		 // get InputStreams representin the upload files content
		 MultipartFile  resumeFile=jsData.getResume();
		 MultipartFile  photoFile=jsData.getPhoto();
		 InputStream isResume=resumeFile.getInputStream();
		 InputStream isPhoto=photoFile.getInputStream();
		 //get the names of the uploaded files
		 String resumeFileName=resumeFile.getOriginalFilename();
		 String photoFileName=photoFile.getOriginalFilename();
		 //create outstreams reprsenting empty destination files
		 OutputStream osResume=new FileOutputStream(file.getAbsolutePath()+"\\"+resumeFileName);
		 OutputStream osPhoto=new FileOutputStream(file.getAbsolutePath()+"\\"+photoFileName);
		 // perform file copy operation
		 IOUtils.copy(isResume,osResume);
		 IOUtils.copy(isPhoto,osPhoto);
		 //close stream
		 isResume.close();
		 osResume.close();
		 isPhoto.close();
		 osPhoto.close();
		//prepare  Entity class obj from Model class obj
		  JobSeekerInfo jsInfo=new JobSeekerInfo();
		   jsInfo.setJsName(jsData.getJsName());
		   jsInfo.setJsAddrs(jsData.getJsAddrs());
		   jsInfo.setResumePath(file.getAbsolutePath()+"\\"+resumeFileName);
		   jsInfo.setPhotoPath(file.getAbsolutePath()+"\\"+photoFileName);
		 //use  Service
		   String msg=service.registerJobSeeker(jsInfo);
		 //keep the uploaded file names and  location in model attributes
		   map.put("file1", resumeFileName);
		   map.put("file2", photoFileName);
		   map.put("resultMsg",msg);
		   //return LVN
		return "show_result";
	}
	
	@GetMapping("/list_js")
	public  String   showReport(Map<String,Object> map) {
		System.out.println("JobSeekerOperationsController.showReport()");
		//use service
		List<JobSeekerInfo> list=service.fetchAllJobseekers();
		System.out.println(list.size());
		//add result to model attrbutes
		map.put("jsList", list);
		//return LVN
		return "show_report";
	}
	
	@Autowired
	private ServletContext sc;
	@GetMapping("/download")
	public  String   fileDownload(HttpServletResponse  res,
			                                        @RequestParam("jsId") Integer id,
			                                        @RequestParam("type") String type) throws Exception{
		// get path of the file to be downloaded
		String filePath=null;
		if(type.equalsIgnoreCase("resume"))
		 filePath=service.fetchResumePathByJsId(id);
		else 
			filePath=service.fetchPhotoPathByJsId(id);
		System.out.println(filePath);
		//create File object representing file to be downloaded
		 File file=new File(filePath);
		 //get the length of the file and make it as the response content length
		 res.setContentLengthLong(file.length());
		 //get MIME of the file and make it as the resposen content type
		 String mimeType=sc.getMimeType(filePath);
		 mimeType=mimeType==null?"application/octet-stream":mimeType;
		 res.setContentType(mimeType);
		 //create InputStream pointing to the file
		 InputStream is=new FileInputStream(file);
		 //create OutputStream pointing to response obj
		 OutputStream os=res.getOutputStream();
		 //instruct the browser to give file content as downloadble file
		 res.setHeader("Content-Disposition","attachment;fileName="+file.getName());
		 // write  file content to  response obj
		   IOUtils.copy(is, os);
		  //close streams
		   is.close();
		   os.close();
		return null;  //makes the handler method to send response directly to browser
	}

}
