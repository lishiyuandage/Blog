package com.bigbrotherlee.leeblog.controller;

import java.io.File;
import java.util.Calendar;
import java.util.UUID; 
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


/*
 * 文件上传和视频播放用
 */
@RestController
@RequestMapping("file")
public class FileController {
	public static final String BASE_D="/home/imageserver";
	public static final String BASE_URL="http://image.bigbrotherlee.com";
	
	@PostMapping(value="/upload",produces="text/html; charset=UTF-8")
	public String  fileUpload(HttpSession session,MultipartFile file) {
		Calendar calendar= Calendar.getInstance();
		String result=null;
		String filename="/"+UUID.randomUUID().toString()+file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
		String uri="/"+calendar.get(Calendar.YEAR)+"/"+(calendar.get(Calendar.MONTH)+1)+"/"+calendar.get(Calendar.DAY_OF_MONTH);
		File savedir=new File(BASE_D,uri);
		savedir.mkdirs();
		File savefile=new File(savedir,filename);
		try {
			file.transferTo(savefile);
			result=BASE_URL+uri+filename;
		} catch (Exception e) {
			result="保存出错";
		}
		return result;
	}
	
	@GetMapping("/play/{fileurl}")
	public void fileAsStream(@PathVariable String fileurl) {
		
	}
}
