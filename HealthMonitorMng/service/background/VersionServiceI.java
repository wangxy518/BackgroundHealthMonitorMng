package HealthMonitorMng.service.background;

import HealthMonitorMng.hbm.base.background.Equipment;
import HealthMonitorMng.hbm.base.background.Version;
import HealthMonitorMng.model.DataGrid;
import HealthMonitorMng.model.DataGridJson;
import HealthMonitorMng.service.BaseServiceI;

public interface VersionServiceI extends BaseServiceI{

	/** 
	* @Title: addVersion 
	* @Description: 添加一个版本 
	* @param @param version 版本
	* @param @return    添加的这个版本 
	* @return Version    返回类型 
	*/
	public Version addVersion(Version version);
	/** 
	* @Title: datagrid 
	* @Description: 展示所有版本 
	* @param @param dg 供后台传递参数的model
	* @param @param version 版本
	* @param @return    供jsp页面展示的json字符串
	* @return DataGridJson    返回类型 
	*/
	public DataGridJson datagrid(DataGrid dg, Version version);
	/** 
	* @Title: edit 
	* @Description: 编辑版本 
	* @param @param version 版本
	* @param @return    正在编辑的那个版本
	* @return Version    返回类型 
	*/
	public Version edit(Version version);
	/** 
	* @Title: delete 
	* @Description: 删除一个或多个版本 
	* @param @param ids   一个或多个版本ID
	* @return void    返回类型 
	*/
	public void delete(String ids);
	

}
