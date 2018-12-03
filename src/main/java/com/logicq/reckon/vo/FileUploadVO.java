package com.logicq.reckon.vo;

import org.springframework.core.io.Resource;

public class FileUploadVO {
	
	private String filename;
	private String filePath;
	private String fileSize;
	private String fileType;
	private Resource resource;
	
	
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getFileSize() {
		return fileSize;
	}
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	
	
	public Resource getResource() {
		return resource;
	}
	public void setResource(Resource resource) {
		this.resource = resource;
	}
	
	@Override
	public String toString() {
		return "FileUploadVO [filename=" + filename + ", filePath=" + filePath + ", fileSize=" + fileSize
				+ ", fileType=" + fileType + ", resource=" + resource + "]";
	}
	
	
	

}
