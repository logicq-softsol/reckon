package com.logicq.reckon.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.logicq.reckon.vo.FileUploadVO;

@RestController
@EnableAutoConfiguration
@RequestMapping("/api")
public class UploadController {

	@Autowired
	ServletContext context;

	@PostMapping("/upload")
	public ResponseEntity<FileUploadVO> uploadFile(@RequestParam("file") MultipartFile uploadfile) throws IOException {
		FileUploadVO fileupload = new FileUploadVO();
		byte[] bytes = uploadfile.getBytes();
		Path path = Paths.get("F:\\company\\reckonplus\\reckon\\src\\main\\resources\\static\\assets\\video\\"
				+ uploadfile.getOriginalFilename());
		Files.write(path, bytes);
		fileupload.setFilename(uploadfile.getOriginalFilename());
		fileupload.setFilePath("http://127.0.0.1:8080/" + "assets/video/" + uploadfile.getOriginalFilename());
		fileupload.setFileType(uploadfile.getContentType());
		return new ResponseEntity(fileupload, HttpStatus.OK);

	}
}
