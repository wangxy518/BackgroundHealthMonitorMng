package HealthMonitorMng.service.impl.background;

import java.security.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import HealthMonitorMng.hbm.base.background.HealthExamination;
import HealthMonitorMng.hbm.base.background.Version;
import HealthMonitorMng.model.DataGrid;
import HealthMonitorMng.model.DataGridJson;
import HealthMonitorMng.service.background.HealthExaminationServiceI;
import HealthMonitorMng.service.background.VersionServiceI;
import HealthMonitorMng.service.impl.BaseServiceImpl;
import HealthMonitorMng.util.DateUtil;

@Transactional
@Service("healthExaminationService")
public class HealthExaminationImpl extends BaseServiceImpl implements HealthExaminationServiceI{

	@Override
	public HealthExamination addHealthExamination(
			HealthExamination healthExamination) {
		healthExamination.setId(UUID.randomUUID().toString());
		String dateTime = DateUtil.getCurrentLongDateTime();
		healthExamination.setCreateTime(dateTime);
		HealthExamination h=new HealthExamination();
		BeanUtils.copyProperties(healthExamination, h);
		super.getBaseDao().save(h);
		return healthExamination;
	}

	@Override
	public DataGridJson datagrid(DataGrid dg,
			HealthExamination healthExamination) {
		DataGridJson j = new DataGridJson();
        String hql = " from HealthExamination t where 1=1 ";
        List<Object> values = new ArrayList<Object>();
        String totalHql = " select count(*) " + hql;
        j.setTotal(super.getBaseDao().count(totalHql, values));// 设置总记录数
        if (dg.getSort() != null) {// 设置排序
            hql += " order by " + dg.getSort() + " " + dg.getOrder();
        } else {
            hql += " order by id desc ";
        }
        List<HealthExamination> ol = super.getBaseDao().find(hql, dg.getPage(), dg.getRows(), values);// 查询分页
        List<HealthExamination> nl = new ArrayList<HealthExamination>();
        if (ol != null && ol.size() > 0) {// 转换模型
            for (HealthExamination o : ol) {
            	HealthExamination h = new HealthExamination();
                BeanUtils.copyProperties(o,h);
                nl.add(h);
            }
        }
        j.setRows(nl);// 设置返回的行
        return j;
	}

	@Override
	public HealthExamination edit(HealthExamination healthExamination) {
		HealthExamination h=(HealthExamination) super.getBaseDao().get(HealthExamination.class, healthExamination.getId());
		BeanUtils.copyProperties(healthExamination, h);
		return healthExamination;
	}

	@Override
	public void delete(String ids) {
		for (String id : ids.split(",")) {
            if (id != null && !id.equals("")) {
            	HealthExamination h = (HealthExamination) super.getBaseDao().load(HealthExamination.class, id);
                super.getBaseDao().delete(h);
            }
        }
	}

}
