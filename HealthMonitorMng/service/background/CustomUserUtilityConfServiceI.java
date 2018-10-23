package HealthMonitorMng.service.background;

import java.util.List;

import HealthMonitorMng.hbm.configEntity.UtilityConfig;
import HealthMonitorMng.model.DataGrid;
import HealthMonitorMng.model.DataGridJson;
import HealthMonitorMng.service.BaseServiceI;


/**@anthor Brave Han*/
public interface CustomUserUtilityConfServiceI extends BaseServiceI{
    //以后决定是否添加用户属性查询
	public List<UtilityConfig> getList();
	public void addOne(UtilityConfig utility);
	public DataGridJson datagrid(DataGrid dg);
	public void delete(String ids);
}
