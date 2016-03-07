package com.itheima.action;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class Upload1Action extends ActionSupport {
	
	private String name;
	private File photo;//���ϴ�����������һ�£�������File����
	private String photoFileName;//�ļ��� ��  �ϴ�����������FileName
	private String photoContentType;//�ϴ����ļ���MIME����
	
	
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
		//�ϴ�
		String storeDirectory = ServletActionContext.getServletContext().getRealPath("/files");
		
		FileUtils.copyFile(photo, new File(storeDirectory, photoFileName));
		
		return SUCCESS;
	}
}