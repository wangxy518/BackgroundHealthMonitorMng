package HealthMonitorMng.service.background;

import HealthMonitorMng.hbm.base.background.HealthExamination;
import HealthMonitorMng.model.DataGrid;
import HealthMonitorMng.model.DataGridJson;
import HealthMonitorMng.service.BaseServiceI;

public interface HealthExaminationServiceI extends BaseServiceI{

	/** 
	* @Title: addHealthExamination 
	* @Description: 添加一个版本 
	* @param @param HealthExamination 版本
	* @param @return    添加的这个版本 
	* @return HealthExamination    返回类型 
	*/
	public HealthExamination addHealthExamination(HealthExamination healthExamination);
	/** 
	* @Title: datagrid 
	* @Description: 展示所有版本 
	* @param @param dg 供后台传递参数的model
	* @param @param HealthExamination 版本
	* @param @return    供jsp页面展示的json字符串
	* @return DataGridJson    返回类型 
	*/
	public DataGridJson datagrid(DataGrid dg, HealthExamination healthExamination);
	/** 
	* @Title: edit 
	* @Description: 编辑版本 
	* @param @param HealthExamination 版本
	* @param @return    正在编辑的那个版本
	* @return HealthExamination    返回类型 
	*/
	public HealthExamination edit(HealthExamination healthExamination);
	/** 
	* @Title: delete 
	* @Description: 删除一个或多个版本 
	* @param @param ids   一个或多个版本ID
	* @return void    返回类型 
	*/
	public void delete(String ids);

}
