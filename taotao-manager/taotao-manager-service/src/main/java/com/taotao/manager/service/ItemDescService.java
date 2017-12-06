package com.taotao.manager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.abel533.entity.Example;
import com.github.abel533.entity.Example.Criteria;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.manager.pojo.TbItemDesc;
 
@Service
public class ItemDescService extends BaseService<TbItemDesc>{

	@Override
	public PageInfo<TbItemDesc> queryPageListByWhere(Integer page, Integer rows, TbItemDesc record, String orderProperty, String orderDir) {
		Example example = new Example(TbItemDesc.class);
		Criteria criteria = example.createCriteria();
		
		Long id = record.getItemId();
		String itemDesc = record.getItemDesc();	

		if (id != null && id.toString() != "") {
			criteria.andLike("id", "%" + id + "%");
		}
		if (itemDesc != null && itemDesc != "") {
			criteria.andLike("itemDesc", "%" + itemDesc + "%");
		}
		
		PropertyMapService propertyMapService = new PropertyMapService(TbItemDesc.class);
		if (orderProperty != null && orderProperty != "" && orderDir != null && orderDir != "") {
			example.setOrderByClause(propertyMapService.getColumn(orderProperty) + " " + orderDir);
		}
		
		PageHelper.startPage(page, rows);
		List<TbItemDesc> list =  super.getMapper().selectByExample(example);
		return new PageInfo<TbItemDesc>(list);
	}
	
}
