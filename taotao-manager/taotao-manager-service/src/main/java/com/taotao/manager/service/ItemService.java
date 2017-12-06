package com.taotao.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.abel533.entity.Example;
import com.github.abel533.entity.Example.Criteria;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.IDUtils;
import com.taotao.manager.pojo.TbItem;
import com.taotao.manager.pojo.TbItemDesc;
import com.taotao.manager.pojo.TbItemParam;
 
@Service
public class ItemService extends BaseService<TbItem>{

	@Autowired ItemDescService itemDescService;
	@Autowired ItemParamService itemParamService;
	@Override
	public PageInfo<TbItem> queryPageListByWhere(Integer page, Integer rows, TbItem record, String orderProperty, String orderDir) {
		Example example = new Example(TbItem.class);
		Criteria criteria = example.createCriteria();
		
		Long catId = record.getCatId();
		Long id = record.getId();
		String title = record.getTitle();
		String barcode = record.getBarcode();
		
		if (catId != null && catId.toString() != "") {
			criteria.andEqualTo("catId", catId);
		}
		if (id != null && id.toString() != "") {
			criteria.andLike("id", "%" + id + "%");
		}
		if (title != null && title != "") {
			criteria.andLike("title", "%" + title + "%");
		}
		if (barcode != null && barcode != "") {
			criteria.andLike("barcode", "%" + barcode + "%");
		}
		
		PropertyMapService propertyMapService = new PropertyMapService(TbItem.class);
		if (orderProperty != null && orderProperty != "" && orderDir != null && orderDir != "") {
			example.setOrderByClause(propertyMapService.getColumn(orderProperty) + " " + orderDir);
		}
		
		PageHelper.startPage(page, rows);
		List<TbItem> list =  super.getMapper().selectByExample(example);
		return new PageInfo<TbItem>(list);
	}
	
	public TaotaoResult saveItem(TbItem item, String desc, String param) {
		// 设置初始数据
        item.setStatus((byte)1);
        item.setId(IDUtils.genItemId());// 强制设置id为null

        this.save(item);// 保存商品基本信息

        TbItemDesc itemDesc = new TbItemDesc();
        itemDesc.setItemId(item.getId());
        itemDesc.setItemDesc(desc);
        // 保存描述数据
        this.itemDescService.save(itemDesc);

        // 保存规格参数数据
        TbItemParam itemParam = new TbItemParam();
        itemParam.setItemId(item.getId());
        itemParam.setParamData(param);
        this.itemParamService.save(itemParam);
        
        return TaotaoResult.ok();
	}
	
	@RequestMapping(value="/item/save.action", method=RequestMethod.POST)
	@ResponseBody
	public TaotaoResult itemSave(TbItem item, String desc, String param) throws Exception {
		TaotaoResult result = this.saveItem(item, desc,param);
		return result;
	}
	
}
