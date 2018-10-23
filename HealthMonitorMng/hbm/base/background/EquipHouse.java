package HealthMonitorMng.hbm.base.background;

import java.io.Serializable;


public class EquipHouse implements Serializable{
	private String dataId;
	private String equipId;
	private String houseId;
	public String getDataId() {
		return dataId;
	}
	public void setDataId(String dataId) {
		this.dataId = dataId;
	}
	public String getEquipId() {
		return equipId;
	}
	public void setEquipId(String equipId) {
		this.equipId = equipId;
	}
	public String getHouseId() {
		return houseId;
	}
	public void setHouseId(String houseId) {
		this.houseId = houseId;
	}
	@Override
	public String toString() {
		return "EquipHouse [dataId=" + dataId + ", equipId=" + equipId
				+ ", houseId=" + houseId + "]";
	}
	

}
