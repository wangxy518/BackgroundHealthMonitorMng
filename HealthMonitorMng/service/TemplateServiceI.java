/**
 * TemplateServiceI.java
 * onesun.service
 *
 * Function： TODO 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2015年4月3日 		wuhoushuang
 *
 * Copyright (c) 2015, TNT All Rights Reserved.
 */

package HealthMonitorMng.service;

import java.util.List;

import HealthMonitorMng.hbm.base.Template;
import HealthMonitorMng.model.DataGrid;
import HealthMonitorMng.model.DataGridJson;
import HealthMonitorMng.model.TemplateAjaxJson;

/**
 * ClassName:TemplateServiceI Function: TODO ADD FUNCTION Reason: TODO ADD
 * REASON
 *
 * @author dingmingliang
 * @version
 * @since Ver 1.1
 * @Date 2015年4月3日 下午4:24:57
 *
 * @see
 * 
 */
public interface TemplateServiceI extends BaseServiceI {
	
	public DataGridJson datagrid(DataGrid dg, TemplateAjaxJson templateAjaxJson);

	public TemplateAjaxJson add(TemplateAjaxJson templateAjaxJson);

	public TemplateAjaxJson edit(TemplateAjaxJson templateAjaxJson);

	public void del(String ids);
	
	public List<Template> list();
	
}
