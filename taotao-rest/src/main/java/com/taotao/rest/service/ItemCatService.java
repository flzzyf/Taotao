package com.taotao.rest.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.abel533.entity.Example;
import com.github.abel533.entity.Example.Criteria;

import com.taotao.manager.mapper.TbItemCatMapper;
import com.taotao.manager.pojo.ItemCat;
import com.taotao.manager.pojo.ItemCatResult;
import com.taotao.manager.pojo.TbItemCat;

@Service
public class ItemCatService {

	@Autowired
	private TbItemCatMapper itemCatMapper;
	
	public ItemCatResult queryAllCategory() throws Exception {
		
		for(int i = 0; i < 20; i++)
			System.out.println("queryAllCategory()");
		
		ItemCatResult result = new ItemCatResult();
		result.setData(getItemCatList(0l));
		
		return result;
	}
	
	/**
	 * 查询分类列表
	 * <p>Title: getItemCatList</p>
	 * <p>Description: </p>
	 * @param parentid
	 * @return
	 */
	private List<?> getItemCatList(long parentid) {
		Example example = new Example(TbItemCat.class);
		Criteria criteria = example.createCriteria();
		//查询parentid为0的分类信息
		criteria.andEqualTo("parentId", parentid);
		List<TbItemCat> list = itemCatMapper.selectByExample(example);
		//List dataList = new ArrayList();###
		List dataList = null;
		
		for (TbItemCat tbItemCat : list) {
			//判断是否为父节点
			if (tbItemCat.getIsParent()) {
				ItemCat itemCat = new ItemCat();
				itemCat.setUrl("/category/" + tbItemCat.getId() + ".html");
				itemCat.setName(tbItemCat.getName());
				//递归调用
				itemCat.setItem(getItemCatList(tbItemCat.getId()));
				//添加到列表
				dataList.add(itemCat);
			} else {
				String catItem = "/item/" + tbItemCat.getId() + ".html|" + tbItemCat.getName();
				dataList.add(catItem);
			}
		}
		return dataList;
	}
}