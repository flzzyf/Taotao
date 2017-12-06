package com.taotao.manager.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.ZTreeNode;
import com.taotao.manager.pojo.TbItemCat;
import com.taotao.manager.service.ItemCatService;

@Controller
public class ItemCatController {

	@Autowired
	private ItemCatService itemCatService;

	@RequestMapping("/item/cat/list.action")
	@ResponseBody
	public List<ZTreeNode> getItemCatList(@RequestParam(value="id", defaultValue="0")Long parentId) throws Exception {
		TbItemCat itemCat = new TbItemCat();
		itemCat.setParentId(parentId);
		List<TbItemCat> list =itemCatService.queryListByWhere(itemCat, "", "");
		List<ZTreeNode> list2 = new ArrayList<>();
		for (TbItemCat tbItemCat : list) {
			ZTreeNode node = new ZTreeNode();
			node.setId(tbItemCat.getId());
			node.setName(tbItemCat.getName());
			node.setIsParent(tbItemCat.getIsParent());
			list2.add(node);
		}
		return list2;
	}
	
}