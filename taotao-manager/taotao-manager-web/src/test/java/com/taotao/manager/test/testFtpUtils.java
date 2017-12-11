package com.taotao.manager.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.junit.Test;

import com.taotao.common.utils.FtpUtils;

public class testFtpUtils {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("qwe");
		
		FileInputStream inputStream;
		try {
			inputStream = new FileInputStream(new File("/Users/zyf/Desktop/master_of_the_sun_by_yakovlev_vad-dbmoohw.png"));
			
			FtpUtils.uploadFile("10.211.55.3", 21, "ftpuser", "root", "", "/images/", "hello2.png", inputStream);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
