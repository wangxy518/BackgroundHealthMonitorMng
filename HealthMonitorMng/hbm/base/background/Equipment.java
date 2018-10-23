package HealthMonitorMng.hbm.base.background;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.web.multipart.MultipartFile;

@JsonIgnoreProperties(value={"equipmentImage"})
public class Equipment implements Serializable,Cloneable{
	@Override  
    public Object clone() {  
        Equipment eq = null;  
        try{  
            eq = (Equipment)super.clone();  
        }catch(CloneNotSupportedException e) {  
            e.printStackTrace();  
        }  
        return eq;  
    } 
	private String dataId;
	private String equipmentNumber;
	private String equipmentName;
	private String status;
	private String belongLocation;
	private String application;
	private String ventor;
	private String logo;
	private String describle;
	private String img;
	private String instruction;
	private Set<HealthHouse> healthHouses = new HashSet<HealthHouse>();
	private Set<EquipmentImage> equipmentImage = new HashSet<EquipmentImage>();
	public Set<HealthHouse> getHealthHouses() {
		return healthHouses;
	}
	public void setHealthHouses(Set<HealthHouse> healthHouses) {
		this.healthHouses = healthHouses;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getDescrible() {
		return describle;
	}
	public void setDescrible(String describle) {
		this.describle = describle;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getInstruction() {
		return instruction;
	}
	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}
	public String getDataId() {
		return dataId;
	}
	public void setDataId(String dataId) {
		this.dataId = dataId;
	}
	public String getEquipmentNumber() {
		return equipmentNumber;
	}
	public void setEquipmentNumber(String equipmentNumber) {
		this.equipmentNumber = equipmentNumber;
	}
	public String getEquipmentName() {
		return equipmentName;
	}
	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getBelongLocation() {
		return belongLocation;
	}
	public void setBelongLocation(String belongLocation) {
		this.belongLocation = belongLocation;
	}
	public String getApplication() {
		return application;
	}
	public void setApplication(String application) {
		this.application = application;
	}
	public String getVentor() {
		return ventor;
	}
	public void setVentor(String ventor) {
		this.ventor = ventor;
	}
	
	@Override
	public String toString() {
		return "Equipment [dataId=" + dataId + ", equipmentNumber="
				+ equipmentNumber + ", equipmentName=" + equipmentName
				+ ", status=" + status + ", belongLocation=" + belongLocation
				+ ", application=" + application + ", ventor=" + ventor
				+ ", logo=" + logo + ", describle=" + describle + ", img="
				+ img + ", instruction=" + instruction + "]";
	}
	public Set<EquipmentImage> getEquipmentImage() {
		return equipmentImage;
	}
	public void setEquipmentImage(Set<EquipmentImage> equipmentImage) {
		this.equipmentImage = equipmentImage;
	}
	

}
