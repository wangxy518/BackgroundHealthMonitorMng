package HealthMonitorMng.hbm.base.background;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class HealthHouse implements Serializable{
	private String dataId;
	private String houseName;
	private String houseNumber;
	private String houseLocation;
	private String responsiblePerson;
	private String mobile;
	private Integer equipNumbers;
	private Set<Equipment> equipments = new HashSet<Equipment>();
	public String getDataId() {
		return dataId;
	}
	public void setDataId(String dataId) {
		this.dataId = dataId;
	}
	public String getHouseName() {
		return houseName;
	}
	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}
	public String getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	public String getHouseLocation() {
		return houseLocation;
	}
	public void setHouseLocation(String houseLocation) {
		this.houseLocation = houseLocation;
	}
	public String getResponsiblePerson() {
		return responsiblePerson;
	}
	public void setResponsiblePerson(String responsiblePerson) {
		this.responsiblePerson = responsiblePerson;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Integer getEquipNumbers() {
		return equipNumbers;
	}
	public void setEquipNumbers(Integer equipNumbers) {
		this.equipNumbers = equipNumbers;
	}
	@Override
	public String toString() {
		return "HealthHouse [dataId=" + dataId + ", houseName=" + houseName
				+ ", houseNumber=" + houseNumber + ", houseLocation="
				+ houseLocation + ", responsiblePerson=" + responsiblePerson
				+ ", mobile=" + mobile + ", equipNumbers=" + equipNumbers + "]";
	}
	public Set<Equipment> getEquipments() {
		return equipments;
	}
	public void setEquipments(Set<Equipment> equipments) {
		this.equipments = equipments;
	}
	
}