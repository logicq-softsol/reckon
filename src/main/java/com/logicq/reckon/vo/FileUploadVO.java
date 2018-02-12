package com.logicq.reckon.vo;

public class FileUploadVO {
	
	private String filename;
	private String filePath;
	private String fileSize;
	private String fileType;
	
	
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
	@Override
	public String toString() {
		return "FileUploadVO [filename=" + filename + ", filePath=" + filePath + ", fileSize=" + fileSize
				+ ", fileType=" + fileType + "]";
	}
	
	
	

}
