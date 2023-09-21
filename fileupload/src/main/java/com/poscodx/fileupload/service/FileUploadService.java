package com.poscodx.fileupload.service;

import java.io.File;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {
	private static String SAVE_PATH = "/users/kdj/mysite-uploads";
	
	public String restore(MultipartFile file) {
		String url = null;
		
		File uploadDirectory = new File(SAVE_PATH);
		// 존재하지 않으면 디렉토리 생성.
		if(!uploadDirectory.exists()) {
			uploadDirectory.mkdirs();
		}
		// file이 빈파일 일때. 
		if(file.isEmpty()) {
			return url;
		}
		System.out.println(file.getOriginalFilename());
		
		
		return null;
	}

}
