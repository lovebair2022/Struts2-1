package com.itheima.action;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URLEncoder;

import org.apache.commons.io.FilenameUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class DownLoadAction extends ActionSupport {
	
//	private InputStream in;//有可能出错
	private InputStream photoIn;//要下载的资源的输入流
	private String filename;//下载的文件名
	
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public InputStream getPhotoIn() {
		return photoIn;
	}

	public void setPhotoIn(InputStream photoIn) {
		this.photoIn = photoIn;
	}

	public String download() throws Exception{
		//给输入流赋值
		String realPath = ServletActionContext.getServletContext().getRealPath("/中.jpg");
		filename = FilenameUtils.getName(realPath);
		filename = URLEncoder.encode(filename, "UTF-8");//中文文件名下载乱码
		photoIn = new FileInputStream(realPath);
		return SUCCESS;
	}
}
