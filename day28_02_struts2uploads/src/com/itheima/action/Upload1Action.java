package com.itheima.action;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class Upload1Action extends ActionSupport {
	
	private String name;
	private File photo;//和上传输入域名称一致，必须是File类型
	private String photoFileName;//文件名 ：  上传的输入域名FileName
	private String photoContentType;//上传的文件的MIME类型
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public File getPhoto() {
		return photo;
	}
	public void setPhoto(File photo) {
		this.photo = photo;
	}

	public String getPhotoFileName() {
		return photoFileName;
	}
	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}
	public String getPhotoContentType() {
		return photoContentType;
	}
	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}
	public String upload() throws IOException{
		
		System.out.println(name+":"+photoFileName+":"+photoContentType);
		//上传
		String storeDirectory = ServletActionContext.getServletContext().getRealPath("/files");
		
		FileUtils.copyFile(photo, new File(storeDirectory, photoFileName));
		
		return SUCCESS;
	}
}
