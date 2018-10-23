package HealthMonitorMng.service.impl.background;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hibernate.Query;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import HealthMonitorMng.hbm.base.HealthTips;
import HealthMonitorMng.model.DataGrid;
import HealthMonitorMng.model.DataGridJson;
import HealthMonitorMng.service.background.HealthTipsServiceI;
import HealthMonitorMng.service.impl.BaseServiceImpl;

@Transactional
@Service("healthTipsService")
public class HealthTipsServiceImpl extends BaseServiceImpl implements HealthTipsServiceI{

	@Override
	public HealthTips addHealthTips(HealthTips healthTips) {
		healthTips.setAdviceid(UUID.randomUUID().toString());
		healthTips.setFlag("0");
		HealthTips t=new HealthTips();
		BeanUtils.copyProperties(healthTips, t);
		super.getBaseDao().save(t);
		return healthTips;
	}

	@Override
	public DataGridJson datagrid(DataGrid dg, HealthTips healthTips) {
		DataGridJson j = new DataGridJson();
        String hql = " from HealthTips t where 1=1";
        List<Object> values = new ArrayList<Object>();
        if (healthTips != null) {// 添加查询条件
        	if(healthTips.getAdvicecontent()!=null){
        		 hql += " and advicecontent like '%%" + healthTips.getAdvicecontent() + "%%' ";
        	}
        }
        String totalHql = " select count(*) " + hql;
        j.setTotal(super.getBaseDao().count(totalHql, values));// 设置总记录数
        if (dg.getSort() != null) {// 设置排序
            hql += " order by " + dg.getSort() + " " + dg.getOrder();
        } else {
            hql += " order by kbtype desc ";
        }
        List<HealthTips> ol = super.getBaseDao().find(hql, dg.getPage(), dg.getRows(), values);// 查询分页
        List<HealthTips> nl = new ArrayList<HealthTips>();
        if (ol != null && ol.size() > 0) {// 转换模型
            for (HealthTips o : ol) {
            	HealthTips h = new HealthTips();
                BeanUtils.copyProperties(o,h);
                nl.add(h);
            }
        }
        j.setRows(nl);// 设置返回的行
        return j;
	}

	@Override
	public HealthTips edit(HealthTips healthTips) {
		HealthTips t=(HealthTips) super.getBaseDao().get(HealthTips.class, healthTips.getAdviceid());
		healthTips.setFlag("0");
		BeanUtils.copyProperties(healthTips, t);
		return healthTips;
	}

	@Override
	public void delete(String ids) {
		for (String id : ids.split(",")) {
            if (id != null && !id.equals("")) {
            	HealthTips t = (HealthTips) super.getBaseDao().load(HealthTips.class, id);
                super.getBaseDao().delete(t);
            }
        }
	}

	@Override
	public List<HealthTips> getType() {
		String hql=" select distinct(kbtype) from HealthTips";
		Query query=super.getBaseDao().createQuery(hql);
		List<String> types=query.list();
		List<HealthTips> ts=new ArrayList<HealthTips>();
		for(int i=0;i<types.size();i++){
			HealthTips t=new HealthTips();
			t.setKbtype(types.get(i));
			ts.add(t);
		}
		return ts;
	}

}
