package com.taotao.manager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.abel533.entity.Example;
import com.github.abel533.entity.Example.Criteria;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.manager.pojo.TbItemParam;
 
@Service
public class ItemParamService extends BaseService<TbItemParam>{

	@Override
	public PageInfo<TbItemParam> queryPageListByWhere(Integer page, Integer rows, TbItemParam record, String orderProperty, String orderDir) {
		Example example = new Example(TbItemParam.class);
		Criteria criteria = example.createCriteria();
		

		Long id = record.getId();
		Long itemId = record.getItemId();
		String paramData = record.getParamData();

		if (id != null && id.toString() != "") {
			criteria.andLike("id", "%" + id + "%");
		}
		if (itemId != null && itemId.toString() != "") {
			criteria.andEqualTo("itemId", itemId);
		}
		if (paramData != null && paramData != "") {
			criteria.andLike("paramData", "%" + paramData + "%");
		}
		
		PropertyMapService propertyMapService = new PropertyMapService(TbItemParam.class);
		if (orderProperty != null && orderProperty != "" && orderDir != null && orderDir != "") {
			example.setOrderByClause(propertyMapService.getColumn(orderProperty) + " " + orderDir);
		}
		
		PageHelper.startPage(page, rows);
		List<TbItemParam> list =  super.getMapper().selectByExample(example);
		return new PageInfo<TbItemParam>(list);
	}
	
}
