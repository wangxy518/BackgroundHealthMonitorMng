package HealthMonitorMng.service.background;

import java.util.List;

import HealthMonitorMng.hbm.base.background.Department;
import HealthMonitorMng.model.DataGrid;
import HealthMonitorMng.model.DataGridJson;
import HealthMonitorMng.model.DepartmentModel;
import HealthMonitorMng.model.SportsCondition;

/**
 * @ClassName: DepartmentServiceI
 * @Description: 管理员管理接口
 * @author DingMingliang
 * @date 2015年3月11日
 */
public interface DepartmentServiceI {

	/**
	 * @Title: datagrid
	 * @Description: 部门查看
	 * @param @param dg
	 * @param @param department
	 * @param @return 设定文件
	 * @return DataGridJson 返回类型
	 */
	public DataGridJson datagrid(DataGrid dg, DepartmentModel department);

	/**
	 * @Title: add
	 * @Description: 添加一条部门信息
	 * @param @param department 部门信息
	 * @param @return 部门信息
	 * @return Department 返回类型
	 */
	public DepartmentModel add(DepartmentModel department);

	/**
	 * @Title: edit
	 * @Description: 编辑部门信息
	 * @param @param department 要修改的部门信息
	 * @param @return 修改完的这条部门信息
	 * @return Department 返回类型
	 */
	public DepartmentModel edit(DepartmentModel department);

	/**
	 * @Title: delete
	 * @Description: 删除部门信息
	 * @param @param ids 部门信息ID
	 * @return void 返回类型
	 */
	public void delete(String ids);

	/**
	 * @Title: 查看部门列表
	 * @Description: 查看部门信息
	 * @return void 返回类型部门list
	 */
	public List<DepartmentModel> list();

	/**
	 * @Title: 查看部门运动趋势
	 * @Description: 查看部门运动趋势
	 * @return void 返回list
	 */
	public SportsCondition sports(SportsCondition s);

}