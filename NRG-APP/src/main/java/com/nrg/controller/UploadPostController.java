package com.nrg.controller;

import org.springframework.web.bind.annotation.RestController;


@RestController
public class UploadPostController {

	/*private Logger logger = Logger.getLogger(UploadPostController.class);
	
	@Autowired
	FileDumpService fileDumpService;

	@Value("${file.upload.folderpath}")
	private String UPLOADED_FOLDER;

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
				response = fileDumpService.dumpFile(new File(UPLOADED_FOLDER + file.getOriginalFilename().replaceAll("\\[.*\\]", "")), shift, objectName);
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
	}*/

}