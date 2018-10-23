package HealthMonitorMng.hbm.base.background;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;


public class HealthExamination implements Serializable{
	
	private String id;
	private String indicator;
	private String description;
	private String abbreviate;
	private String createTime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIndicator() {
		return indicator;
	}
	public void setIndicator(String indicator) {
		this.indicator = indicator;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAbbreviate() {
		return abbreviate;
	}
	public void setAbbreviate(String abbreviate) {
		this.abbreviate = abbreviate;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	@Override
	public String toString() {
		return "HealthExamination [id=" + id + ", indicator=" + indicator
				+ ", description=" + description + ", abbreviate=" + abbreviate
				+ ", createTime=" + createTime + "]";
	}
}
