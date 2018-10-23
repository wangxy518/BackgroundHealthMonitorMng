package HealthMonitorMng.service.impl.background;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import HealthMonitorMng.hbm.base.background.UserLog;
import HealthMonitorMng.model.DataGrid;
import HealthMonitorMng.model.DataGridJson;
import HealthMonitorMng.model.UserLogModel;
import HealthMonitorMng.service.background.ShowUserLogServiceI;
import HealthMonitorMng.service.impl.BaseServiceImpl;

@Transactional
@Service("showUserLogService")
public class ShowUserLogServiceImpl extends BaseServiceImpl implements
		ShowUserLogServiceI {

	@Override
	public DataGridJson showUserLog(DataGrid dg, UserLogModel userLog) {
		DataGridJson j = new DataGridJson();
		String hql = " from UserLog t where 1=1 ";
		List<Object> values = new ArrayList<Object>();
		if (userLog != null) {// 添加查询条件
			if (userLog.getUserName() != null
					&& !"".equals(userLog.getUserName())) {
				hql += " and userName like '%%"+ userLog.getUserName() +"%%' ";
			}
		}
		if (userLog.getStartTime() != null) {
			hql += " and time >= '"+ DateToTimestamp(userLog.getStartTime()) + "'";
		}
		if (userLog.getEndTime() != null) {
			hql += " and time <= '"+ DateToTimestamp(userLog.getEndTime()) + "'";
		}
		String totalHql = " select count(*) " + hql;
		j.setTotal(super.getBaseDao().count(totalHql, values));// 设置总记录数
		if (dg.getSort() != null) {// 设置排序
			hql += " order by " + dg.getSort() + " " + dg.getOrder();
		} else {
			hql += " order by time desc ";
		}
		List<UserLog> ol = super.getBaseDao().find(hql, dg.getPage(),
				dg.getRows(), values);// 查询分页
		List<UserLog> nl = new ArrayList<UserLog>();
		if (ol != null && ol.size() > 0) {// 转换模型
			for (UserLog o : ol) {
				UserLog e = new UserLog();
				BeanUtils.copyProperties(o, e);
				nl.add(e);
			}
		}
		j.setRows(nl);// 设置返回的行
		return j;
	}

	public Timestamp DateToTimestamp(Date date) {
		String dateStr = "";
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		try {
			dateStr = sdf.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		try {
			ts = Timestamp.valueOf(dateStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ts;
	}

}
