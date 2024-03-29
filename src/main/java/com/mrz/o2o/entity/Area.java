package com.mrz.o2o.entity;

import java.util.Date;

public class Area {

	@Override
	public String toString() {
		return "Area [areaId=" + areaId + ", areName=" + areaName + ", priority=" + priority + ", createTime="
				+ createTime + ", lastEditTime=" + lastEditTime + "]";
	}

	private Integer areaId;
	private String areaName;
	private Integer priority;
	private Date createTime;
	private Date lastEditTime;

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreName(String areaName) {
		this.areaName = areaName;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastEditTime() {
		return lastEditTime;
	}

	public void setLastEditTime(Date lastEditTime) {
		this.lastEditTime = lastEditTime;
	}

}
