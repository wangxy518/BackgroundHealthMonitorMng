package HealthMonitorMng.service.background;


import HealthMonitorMng.model.DataGrid;
import HealthMonitorMng.model.DataGridJson;
import HealthMonitorMng.model.UserLogModel;
import HealthMonitorMng.service.BaseServiceI;

/** 
* @ClassName: ShowUserLogServiceI 
* @Description: 展示日志接口 
* @author WuHoushuang 
* @date 2015年2月3日 下午7:35:22 
*/
public interface ShowUserLogServiceI extends BaseServiceI{
	/** 
	* @Title: showUserLog 
	* @Description: 展示日志
	* @param @param dg 向后台传递参数的model
	* @param @param userLog 用户日志
	* @param @return    供jsp页面解析的json字符串
	* @return DataGridJson    返回类型 
	* @throws 
	*/
	DataGridJson showUserLog(DataGrid dg, UserLogModel userLog);

}
