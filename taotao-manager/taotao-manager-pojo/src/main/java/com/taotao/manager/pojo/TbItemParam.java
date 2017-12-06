package com.taotao.manager.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tb_item_param")
public class TbItemParam extends BasePojo{
 
	@Id
	private Long id;
	@Column
	private Long itemId;
	@Column
    private String paramData;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public String getParamData() {
		return paramData;
	}
	public void setParamData(String paramDate) {
		this.paramData = paramDate;
	}

	
    
    
}
