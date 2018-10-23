package HealthMonitorMng.hbm.base.background;

import java.io.Serializable;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;




public class EquipmentImage implements Serializable{
	private String dataId;
	private String equipmentId;
	private String image;
	private String imageNumber;

	private Equipment equipment = new Equipment();
	public String getDataId() {
		return dataId;
	}
	public void setDataId(String dataId) {
		this.dataId = dataId;
	}
	public String getEquipmentId() {
		return equipmentId;
	}
	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getImageNumber() {
		return imageNumber;
	}
	public void setImageNumber(String imageNumber) {
		this.imageNumber = imageNumber;
	}
	public Equipment getEquipment() {
		return equipment;
	}
	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}
}