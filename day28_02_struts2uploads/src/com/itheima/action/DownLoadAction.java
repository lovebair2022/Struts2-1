package com.itheima.action;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URLEncoder;

import org.apache.commons.io.FilenameUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class DownLoadAction extends ActionSupport {
	
//	private InputStream in;//�п��ܳ���
	private InputStream photoIn;//Ҫ���ص���Դ��������
	private String filename;//���ص��ļ���
	
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
		//����������ֵ
		String realPath = ServletActionContext.getServletContext().getRealPath("/��.jpg");
		filename = FilenameUtils.getName(realPath);
		filename = URLEncoder.encode(filename, "UTF-8");//�����ļ�����������
		photoIn = new FileInputStream(realPath);
		return SUCCESS;
	}
}
