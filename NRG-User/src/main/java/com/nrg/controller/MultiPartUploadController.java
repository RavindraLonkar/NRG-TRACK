package com.nrg.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.nrg.utils.CommonConstants;
import com.nrg.utils.CommonUserMessages;
import com.nrg.utils.Response;

@RestController
public class MultiPartUploadController {

	@Autowired
	ServletContext context;

	@Value("${PROFILE_UPLOAD_FOLDER_PREFIX}")
	private String PROFILE_UPLOAD_FOLDER_PREFIX;

	@Value("${PROFILE_UPLOAD_FOLDER_SUFFIX}")
	private String PROFILE_UPLOAD_FOLDER_SUFFIX;

	@RequestMapping(value = "/profileUpload", method = RequestMethod.POST)
	public Response profilePhotoUpload(@RequestParam("file") MultipartFile file) {
		Response response = null;
		// User user = (User) request.getSession().getAttribute("usersession");
		String profilePhotoPath = PROFILE_UPLOAD_FOLDER_PREFIX;
		String absolutePath = context. getRealPath(profilePhotoPath);
		File folderFile = new File(absolutePath);
		try {
			if (!folderFile.isDirectory()) {
				folderFile.mkdirs();
			} else {
				folderFile.delete();
			}

			byte[] bytes = file.getBytes();
			Path path = Paths.get(absolutePath + "/" + file.getOriginalFilename());
			Files.write(path, bytes);
			response = new Response(CommonConstants.NRG_SCUCESS, null, CommonUserMessages.FILE_UPLOAD_SUCCESSFULLY);

		} catch (IOException e) {
			System.out.println(e.getMessage());
			response = new Response(CommonConstants.NRG_FAIL, null, CommonUserMessages.SYSTEM_ERROR);
		}
		return response;
	}
}
