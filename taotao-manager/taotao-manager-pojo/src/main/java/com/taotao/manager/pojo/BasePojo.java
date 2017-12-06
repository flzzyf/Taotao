package com.taotao.manager.pojo;

import java.util.Date;

import javax.persistence.Column;
 
public abstract class BasePojo {
    
	@Column(name = "create_time")
    private Date createTime;
    
	@Column(name = "update_time")
    private Date updateTime;

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
    
}
