package HealthMonitorMng.service.background;

import java.util.List;

import HealthMonitorMng.hbm.base.HealthTips;
import HealthMonitorMng.model.DataGrid;
import HealthMonitorMng.model.DataGridJson;
import HealthMonitorMng.service.BaseServiceI;

/** 
* @ClassName: HealthTipsServiceI 
* @Description: 健康贴士接口 
* @author WuHoushuang 
* @date 2015年3月11日 下午5:44:39 
* @changelog 更改日志：增加健康贴士
*/
public interface HealthTipsServiceI extends BaseServiceI{
	/** 
	* @Title: addHealthTips 
	* @Description: 添加健康贴士
	* @param @param healthTips
	* @param @return    设定文件 
	* @return HealthTips    健康贴士
	* @throws 
	* @changelog 更改日志：增加添加健康贴士
	*/
	public HealthTips addHealthTips(HealthTips healthTips);
	/** 
	* @Title: datagrid 
	* @Description: 获取所有健康贴士 
	* @param @param dg
	* @param @param healthTips
	* @param @return    设定文件 
	* @return DataGridJson    供jsp页面解析的json
	* @throws 
	* @changelog 更改日志：增加获取所有json
	*/
	public DataGridJson datagrid(DataGrid dg, HealthTips healthTips);
	/** 
	* @Title: edit 
	* @Description: 编辑健康贴士 
	* @param @param healthTips
	* @param @return    设定文件 
	* @return HealthTips   健康贴士
	* @throws 
	* @changelog 更改日志：增加编辑健康贴士
	*/
	public HealthTips edit(HealthTips healthTips);
	/** 
	* @Title: delete 
	* @Description: 删除一个或多个健康贴士
	* @param @param ids   一个或多个设备ID
	* @return void    返回类型 
	*/
	public void delete(String ids);
	public List<HealthTips> getType();
	

}
