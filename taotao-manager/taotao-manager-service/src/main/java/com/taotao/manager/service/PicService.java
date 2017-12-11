package com.taotao.manager.service;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.FtpUtils;
import com.taotao.common.utils.IDUtils;

@Service
public class PicService {

	//@Value("${FTP_ADDRESS}")
	private String FTP_ADDRESS;
	
	//@Value("${FTP_PORT}")
	private Integer FTP_PORT;
	
	//@Value("${FTP_USERNAME}")
	private String FTP_USERNAME;
	
	//@Value("${FTP_PASSWORD}")
	private String FTP_PASSWORD;
	
	//@Value("${FTP_BASE_PATH}")
	private String FTP_BASE_PATH;
	
	//@Value("${IMAGE_BASE_URL}")
	private String IMAGE_BASE_URL;

	public TaotaoResult uploadPicture(MultipartFile uploadFile) {
		
		FTP_ADDRESS = "10.211.55.3";
		FTP_PORT = 21;
		FTP_USERNAME = "ftpuser";
		FTP_PASSWORD = "root";
		FTP_BASE_PATH = "/images";
		IMAGE_BASE_URL = "http://10.211.55.3";
		
		//判断上传图片是否为空
		if (null == uploadFile || uploadFile.isEmpty()) {
			return TaotaoResult.build(500, "上传图片为空", "");
		}
		//取文件扩展名
		String originalFilename = uploadFile.getOriginalFilename();
		String ext = originalFilename.substring(originalFilename.lastIndexOf("."));
		//生成新文件名
		//可以使用uuid生成新文件名。
		//UUID.randomUUID()
		//可以是时间+随机数生成文件名
		String imageName = IDUtils.genImageName();
		//把图片上传到ftp服务器（图片服务器）
		//需要把ftp的参数配置到配置文件中
		//文件在服务器的存放路径，应该使用日期分隔的目录结构
		DateTime dateTime = new DateTime();
		String filePath = dateTime.toString("/yyyy/MM/dd");
		try {
			FtpUtils.uploadFile(FTP_ADDRESS, FTP_PORT, FTP_USERNAME, FTP_PASSWORD, 
					FTP_BASE_PATH, filePath, imageName + ext, uploadFile.getInputStream());
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoResult.build(500, ExceptionUtils.getStackTrace(e));
		}
		//返回结果，生成一个可以访问到图片的url返回
		
		return TaotaoResult.build(200, "上传成功", IMAGE_BASE_URL + filePath + "/" + imageName + ext);
	}

}