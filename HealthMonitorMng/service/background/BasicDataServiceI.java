package HealthMonitorMng.service.background;

import java.util.List;

import HealthMonitorMng.hbm.base.background.DetectObject;
import HealthMonitorMng.hbm.base.background.BasicData.Area;
import HealthMonitorMng.hbm.base.background.BasicData.BasicData;
import HealthMonitorMng.hbm.base.background.BasicData.City;
import HealthMonitorMng.hbm.base.background.BasicData.Province;
import HealthMonitorMng.model.DataGrid;
import HealthMonitorMng.model.DataGridJson;
import HealthMonitorMng.model.Location;
import HealthMonitorMng.service.BaseServiceI;

/** 
* @ClassName: BasicDataServiceI 
* @Description: 基础数据维护接口
* @author WuHoushuang 
* @date 2015年2月3日 下午3:34:20 
* @changelog 更改日志：增加了省市区的查询
*/
public interface BasicDataServiceI extends BaseServiceI{
	/** 
	* @Title: addBasicData 
	* @Description: 增加基础数据维护 
	* @param @param basicData 基础数据类
	* @param @return    设定文件 
	* @return BasicData    返回类型  基础数据类
	* @throws 
	*/
	public BasicData addBasicData(BasicData basicData);
	/** 
	* @Title: datagrid 
	* @Description: 展示基础数据维护 
	* @param @param dg 供后台传递参数的model
	* @param @param basicData 基础数据维护类
	* @param @return    设定文件 
	* @return DataGridJson    返回类型   供jsp页面展示的json字符串
	* @throws 
	*/
	public DataGridJson datagrid(DataGrid dg, BasicData basicData);
	/** 
	* @Title: edit 
	* @Description: 编辑或修改基础数据维护 
	* @param @param basicData 基础数据维护类
	* @param @return    设定文件 
	* @return BasicData    返回类型  基础数据维护类
	* @throws 
	*/
	public BasicData edit(BasicData basicData);
	/** 
	* @Title: delete 
	* @Description: 删除一个或者多个基础数据
	* @param @param ids    一个或多个基础数据的id 
	* @return void    返回类型 
	* @throws 
	*/
	public void delete(String ids);
	/** 
	* @Title: getDetectName 
	* @Description: 获取检测对象类型名称
	* @param @return   检测对象类型名称集合
	* @return List<DetectObject>    返回类型 
	*/
	public List<DetectObject> getDetectName();
	/** 
	* @Title: getProvinces 
	* @Description: 获取所有省份
	* @param @return    省份集合
	* @return List<Province>    返回类型 
	*/
	public List<Province> getProvinces();
	/** 
	* @Title: getCities 
	* @Description: 获取所有城市 
	* @param @param provinceid 根据省份Id获取
	* @param @return    所有城市的集合
	* @return List<City>    返回类型 
	*/
	public List<City> getCities(String provinceid);
	/** 
	* @Title: getAreas 
	* @Description: 获取所有地区
	* @param @param cityid 根据城市Id获取地区
	* @param @return    所有地区集合
	* @return List<Area>    返回类型 
	*/
	public List<Area> getAreas(String cityid);
	/** 
	* @Title: getProvince 
	* @Description: 获取某个省份
	* @param @param provinceid 省份ID
	* @param @return    某个省份 
	* @return Province    返回类型 
	*/
	public Province getProvince(String provinceid);
	/** 
	* @Title: getCity 
	* @Description: 获取某个城市
	* @param @param cityid 城市ID
	* @param @return    某个城市
	* @return City    返回类型 
	*/
	public City getCity(String cityid);
	
	/** 
	* @Title: getArea 
	* @Description: 获取某个地区
	* @param @param areaid 地区ID
	* @param @return    某个地区
	* @return Area    返回类型 
	*/
	public Area getArea(String areaid);
	public BasicData getData(String rowId);
}
