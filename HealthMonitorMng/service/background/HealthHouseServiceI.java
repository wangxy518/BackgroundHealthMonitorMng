package HealthMonitorMng.service.background;

import java.util.List;

import HealthMonitorMng.hbm.base.background.HealthHouse;
import HealthMonitorMng.hbm.base.background.BasicData.Area;
import HealthMonitorMng.hbm.base.background.BasicData.BasicData;
import HealthMonitorMng.hbm.base.background.BasicData.City;
import HealthMonitorMng.hbm.base.background.BasicData.Province;
import HealthMonitorMng.model.DataGrid;
import HealthMonitorMng.model.DataGridJson;
import HealthMonitorMng.service.BaseServiceI;

/** 
* @ClassName: HealthHouseServiceI 
* @Description: 小屋管理接口
* @author WuHoushuang 
* @date 2015年2月3日 下午7:13:10 
*/
public interface HealthHouseServiceI extends BaseServiceI{
	/** 
	* @Title: add 
	* @Description: 添加小屋 
	* @param @param healthHouse 小屋类
	* @param @return    健康小屋实体
	* @return HealthHouse    返回类型 
	* @throws 
	*/
	public HealthHouse add(HealthHouse healthHouse);
	/** 
	* @Title: datagrid 
	* @Description: 展示所有小屋 
	* @param @param dg 供后台传递参数的model
	* @param @param healthHouse 小屋类
	* @param @return    供 jsp页面展示的json字符串
	* @return DataGridJson    返回类型 
	*/
	public DataGridJson datagrid(DataGrid dg, HealthHouse healthHouse);
	/** 
	* @Title: edit 
	* @Description: 编辑小屋
	* @param @param healthHouse 小屋
	* @param @return    小屋类
	* @return HealthHouse    返回类型 
	* @throws 
	*/
	public HealthHouse edit(HealthHouse healthHouse);
	/** 
	* @Title: delete 
	* @Description: 删除小屋 
	* @param @param ids   小屋ID 
	* @return void    返回类型 
	* @throws 
	*/
	public void delete(String ids);
	/** 
	* @Title: getLocation 
	* @Description: 获取小屋名称 
	* @param @return    小屋名称集合 
	* @return List<HealthHouse>    返回类型 
	* @throws 
	*/
	public List<HealthHouse> getLocation();
	/** 
	* @Title: getProvince 
	* @Description: 获取省份 
	* @param @param provinceid 省份ID
	* @param @return    省份
	* @return Province    返回类型 
	*/
	public Province getProvince(String provinceid);
	/** 
	* @Title: getCity 
	* @Description: 获取城市 
	* @param @param cityid 城市ID
	* @param @return    城市 
	* @return City    返回类型 
	*/
	public City getCity(String cityid);
	/** 
	* @Title: getArea 
	* @Description: 获取地区
	* @param @param areaid 地区ID
	* @param @return    地区
	* @return Area    返回类型 
	* @throws 
	*/
	public Area getArea(String areaid);
	/** 
	* @Title: getData 
	* @Description: 编辑时获取小屋地址
	* @param @param rowId 被选中行的ID
	* @param @return    小屋实体
	* @return HealthHouse    返回类型 
	* @throws 
	* @changelog 更改日志：增加获取小屋地址功能
	*/
	public HealthHouse getData(String rowId);
}
