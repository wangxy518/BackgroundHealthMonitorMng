package HealthMonitorMng.hbm.base.background.BasicData;

import java.io.Serializable;

public class Province implements Serializable{
	private String id;
	private String provinceid;
	private String province;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProvinceid() {
		return provinceid;
	}
	public void setProvinceid(String provinceid) {
		this.provinceid = provinceid;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	

}
