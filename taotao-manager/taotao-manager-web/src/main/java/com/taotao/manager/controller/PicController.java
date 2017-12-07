package com.taotao.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.manager.service.PicService;

@Controller
public class PicController {

	@Autowired
	private PicService picService;
	
	@RequestMapping("/pic/upload.action")
	@ResponseBody
	public TaotaoResult upload(@RequestParam ("file") MultipartFile uploadFile) {
		return picService.uploadPicture(uploadFile);
	}
}