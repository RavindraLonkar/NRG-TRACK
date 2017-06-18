package com.nrg.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.nrg.utils.CommonConstants;
import com.nrg.utils.Response;

@RestController
public class UploadPostController {

	private Logger logger = Logger.getLogger(UploadPostController.class);
	
	@Value("${file.upload.folderpath}")
	private String UPLOADED_FOLDER;
	
	@Value("${KF_FILE_UPLOAD_URL}")
	private String KF_FILE_UPLOAD_URL;
	
	Response response = new Response();

	// Save the uploaded file to this folder

	List<Object> objects = new ArrayList<>();

	@PostMapping("/upload") // //new annotation since 4.3
	public Response singleFileUpload(@RequestParam("file") MultipartFile file, @RequestParam("objectName") String objectName,
			@RequestParam("shift") String shift) {
		
		Path path = null;
		if (file.isEmpty()) {
			response = new Response(CommonConstants.KF_FILE_EMPTY, objects, CommonConstants.KF_FILE_EXISTS_MESSAGE);
			return response;
		}

		try {
			// Get the file and save it somewhere
			byte[] bytes = file.getBytes();
			path= Paths.get(UPLOADED_FOLDER + file.getOriginalFilename().replaceAll("\\[.*\\]", ""));
			
			if(Files.exists(path)){
				response = new Response(CommonConstants.KF_FILE_EXISTS, objects, CommonConstants.KF_FILE_EXISTS_MESSAGE);
				return response;
			}
			
			Files.write(path, bytes);

			if (file.getContentType() != null) {
				System.out.println(KF_FILE_UPLOAD_URL);
			}

		} catch (Exception e) {
			
			try {
				Files.delete(path);
				response = new Response(CommonConstants.KF_FAIL, objects, CommonConstants.KF_FAIL_MESSAGE);
			} catch (IOException e1) {
				logger.error(e1.getMessage());
			}
			
		}

		return response;
	}

}