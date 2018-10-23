/**
 * PushMessageServiceI.java
 * onesun.service
 *
 * Function： TODO 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2015年4月2日 		wuhoushuang
 *
 * Copyright (c) 2015, TNT All Rights Reserved.
 */

package HealthMonitorMng.service;

import HealthMonitorMng.hbm.base.PushMessage;
import HealthMonitorMng.model.DataGrid;
import HealthMonitorMng.model.DataGridJson;

/**
 * ClassName:PushMessageServiceI Function: TODO ADD FUNCTION Reason: TODO ADD
 * REASON
 *
 * @author dingmingliang
 * @version
 * @since Ver 1.1
 * @Date 2015年4月2日 下午2:17:43
 *
 * @see
 * 
 */
public interface PushMessageServiceI {

	public DataGridJson datagrid(DataGrid dg, PushMessage pushMessage);

	public PushMessage add(PushMessage pushMessage);

	public PushMessage edit(PushMessage pushMessage);

	public boolean del(String ids);

	public PushMessage getNew();
	
}
