package HealthMonitorMng.hbm.base.background.BasicData;
import java.io.Serializable;

public class BasicData implements Serializable{
	/** 
	* @Fields organizationRealName : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private String organizationRealName;
	private String organizationName;
	private String code;
	private String detectObject;
	private String belongLocation;
	private String dataId;
	private String keepNumberOne;
	private String keepNumbertwo;
	public String getOrganizationRealName() {
		return organizationRealName;
	}
	public void setOrganizationRealName(String organizationRealName) {
		this.organizationRealName = organizationRealName;
	}
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDetectObject() {
		return detectObject;
	}
	public void setDetectObject(String detectObject) {
		this.detectObject = detectObject;
	}
	public String getBelongLocation() {
		return belongLocation;
	}
	public void setBelongLocation(String belongLocation) {
		this.belongLocation = belongLocation;
	}
	public String getDataId() {
		return dataId;
	}
	public void setDataId(String dataId) {
		this.dataId = dataId;
	}
	public String getKeepNumberOne() {
		return keepNumberOne;
	}
	public void setKeepNumberOne(String keepNumberOne) {
		this.keepNumberOne = keepNumberOne;
	}
	public String getKeepNumbertwo() {
		return keepNumbertwo;
	}
	public void setKeepNumbertwo(String keepNumbertwo) {
		this.keepNumbertwo = keepNumbertwo;
	}
	

}
