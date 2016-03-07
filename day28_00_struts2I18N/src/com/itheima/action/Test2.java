package com.itheima.action;

public class Test2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "http://m.hehenian.com/product/queryAgreenment.do?fileName=iv_1452045600444726.pdf";
		String url2 = "/sdcard/"+url.substring(url.lastIndexOf('=')+1);
		System.out.println(url2);

	}

}
