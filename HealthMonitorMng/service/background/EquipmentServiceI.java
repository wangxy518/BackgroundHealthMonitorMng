package HealthMonitorMng.service.background;

import java.util.List;

import HealthMonitorMng.hbm.base.background.Equipment;
import HealthMonitorMng.hbm.base.background.EquipmentImage;
import HealthMonitorMng.model.DataGrid;
import HealthMonitorMng.model.DataGridJson;
import HealthMonitorMng.service.BaseServiceI;

/** 
* @ClassName: EquipmentServiceI 
* @Description: 设备管理接口 
* @author WuHoushuang 
* @date 2015年2月3日 下午5:17:22 
*/
public interface EquipmentServiceI extends BaseServiceI{
    
	/** 
	* @Title: addEquipment 
	* @Description: 添加一个设备 
	* @param @param equipment 设备
	* @param @return    添加的这个设备 
	* @return Equipment    返回类型 
	*/
	public Equipment addEquipment(Equipment equipment);
	/** 
	* @Title: datagrid 
	* @Description: 展示所有设备 
	* @param @param dg 供后台传递参数的model
	* @param @param equipment 设备
	* @param @return    供jsp页面展示的json字符串
	* @return DataGridJson    返回类型 
	*/
	public DataGridJson datagrid(DataGrid dg, Equipment equipment);
	/** 
	* @Title: edit 
	* @Description: 编辑设备 
	* @param @param equipment 设备
	* @param @return    正在编辑的那个设备
	* @return Equipment    返回类型 
	*/
	public Equipment edit(Equipment equipment);
	/** 
	* @Title: delete 
	* @Description: 删除一个或多个设备 
	* @param @param ids   一个或多个设备ID
	* @return void    返回类型 
	*/
	public void delete(String ids);
	/** 
	* @Title: datagridForImage 
	* @Description: 查询设备图片
	* @param @param dg 供后台传递参数的model
	* @param @param equipmentImage 设备图片
	* @return void    返回类型 
	*/
	public DataGridJson datagridForImage(DataGrid dg, Equipment equipment);
	public EquipmentImage addImage(EquipmentImage equipmentImage);
	public List<Equipment> getEquipments(String houseId);
	public void deleteImage(String ids);
	public EquipmentImage editImage(EquipmentImage equipmentImage);
}
