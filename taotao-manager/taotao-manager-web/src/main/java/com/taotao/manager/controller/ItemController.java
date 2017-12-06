package com.taotao.manager.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.DataTableResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.manager.pojo.TbItem;

import com.taotao.manager.service.ItemService;
 
@Controller
public class ItemController {
 
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/item/query.action")
	public String showQuery(Model model) {
		model.addAttribute("menu1", "menu_item");
		model.addAttribute("menu2", "menu_item_query");
		model.addAttribute("nav1", "商品管理");
		model.addAttribute("nav2", "商品列表查询");
		return "item/query";
	}
	
	@RequestMapping("/item/list.action")
	@ResponseBody
	public DataTableResult getItemList(HttpServletRequest request, TbItem item) throws Exception {
		String orderIdx = request.getParameter("order[0][column]");
		Integer draw = Integer.parseInt(request.getParameter("draw"));
		Integer start = Integer.parseInt(request.getParameter("start"));
		Integer length = Integer.parseInt(request.getParameter("length"));
		Integer page = start / length +1 ;
		String orderProperty = request.getParameter("columns[" + orderIdx + "][name]");
		String orderDir = request.getParameter("order[0][dir]");
		
		PageInfo<TbItem> pageInfo = itemService.queryPageListByWhere(page, length, item, orderProperty, orderDir);
		
		DataTableResult result = new DataTableResult();
		result.setDraw(draw);
		result.setRecordsTotal(pageInfo.getTotal());
		result.setRecordsFiltered(result.getRecordsTotal());
		result.setData(pageInfo.getList());

		return result;
	}
	
	@RequestMapping(value = "/item/del.action", method=RequestMethod.POST)
	@ResponseBody
	public TaotaoResult delItem(@RequestParam(value = "ids[]") String[] ids) throws Exception {
		List<Object> idList = new ArrayList<Object>(Arrays.asList(ids));
		Integer delNums = itemService.deleteByIds(TbItem.class, "id", idList);
		if ( delNums > 0) {
			return TaotaoResult.build(200, "已删除" + delNums + "条记录");
		}
		return TaotaoResult.build(500, "删除失败");
	}
	
	
	
	
	
}