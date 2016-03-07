package com.itheima.action;

public class Test {
	
	public static void main(int []args){
		String url = "http://m.hehenian.com/product/queryAgreenment.do?fileName=iv_1452045600444726.pdf";
		String url2 = "/sdcard/"+url.substring(url.lastIndexOf('='));
		System.out.println(url2);
	}

}
