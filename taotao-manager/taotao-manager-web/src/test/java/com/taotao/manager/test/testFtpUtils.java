package com.taotao.manager.test;

import java.io.File;
import java.io.FileInputStream;

import org.junit.Test;

import com.taotao.common.utils.FtpUtils;

public class testFtpUtils {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("qwe");
		
		try {
			testFtpUtils();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Test
	public static void testFtpUtils() throws Exception {
		FileInputStream inputStream = new FileInputStream(new File("/Users/zyf/Desktop/master_of_the_sun_by_yakovlev_vad-dbmoohw.png"));
		FtpUtils.uploadFile("10.211.55.3", 22, "ftpuser", "root", "", "/images/", "helloj.png", inputStream);
	}
	

}
