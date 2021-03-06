package com.taotao.manager.test;


import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

//import com.taotao.common.utils.FtpUtils;

public class FTPTest {

    public static void main(String[] args) { 
        try {
			testFtpClient();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    } 
	
	public static void testFtpClient() throws Exception {
		// 创建一个FtpClient对象
		FTPClient ftpClient = new FTPClient();
		// 创建ftp连接。默认是21端口
		ftpClient.connect("10.211.55.3");
		// 登录ftp服务器，使用用户名和密码
		ftpClient.login("ftpuser", "root");
		
		System.out.println("asd");
		// 上传文件。
		// 读取本地文件
		FileInputStream inputStream = new FileInputStream(
				new File("/Users/zyf/Desktop/master_of_the_sun_by_yakovlev_vad-dbmoohw.png"));
		// 设置上传的路径
		ftpClient.changeWorkingDirectory("images/");
		// 修改上传文件的格式
		ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
		// 第一个参数：服务器端文档名
		// 第二个参数：上传文档的inputStream
		ftpClient.storeFile("hello1.png", inputStream);
		// 关闭连接
		ftpClient.logout();
	}
	
	

}