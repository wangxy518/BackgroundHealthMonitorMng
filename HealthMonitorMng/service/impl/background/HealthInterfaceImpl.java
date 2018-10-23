package HealthMonitorMng.service.impl.background;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import HealthMonitorMng.hbm.base.background.HealthInterface;
import HealthMonitorMng.model.DataGrid;
import HealthMonitorMng.model.DataGridJson;
import HealthMonitorMng.service.background.HealthInterfaceServiceI;
import HealthMonitorMng.service.impl.BaseServiceImpl;
import HealthMonitorMng.util.DateUtil;

@Transactional
@Service("healthInterfaceService")
public class HealthInterfaceImpl extends BaseServiceImpl implements HealthInterfaceServiceI{

	@Override
	public HealthInterface addHealthInterface(
			HealthInterface healthInterface) {
		healthInterface.setId(UUID.randomUUID().toString());
		String dateTime = DateUtil.getCurrentLongDateTime();
		healthInterface.setCreateTime(dateTime);
		HealthInterface h=new HealthInterface();
		BeanUtils.copyProperties(healthInterface, h);
		super.getBaseDao().save(h);
		return healthInterface;
	}

	@Override
	public DataGridJson datagrid(DataGrid dg,
			HealthInterface healthInterface) {
		DataGridJson j = new DataGridJson();
        String hql = " from HealthInterface t where 1=1 ";
        List<Object> values = new ArrayList<Object>();
        String totalHql = " select count(*) " + hql;
        j.setTotal(super.getBaseDao().count(totalHql, values));// 设置总记录数
        if (dg.getSort() != null) {// 设置排序
            hql += " order by " + dg.getSort() + " " + dg.getOrder();
        } else {
            hql += " order by id desc ";
        }
        List<HealthInterface> ol = super.getBaseDao().find(hql, dg.getPage(), dg.getRows(), values);// 查询分页
        List<HealthInterface> nl = new ArrayList<HealthInterface>();
        if (ol != null && ol.size() > 0) {// 转换模型
            for (HealthInterface o : ol) {
            	HealthInterface h = new HealthInterface();
                BeanUtils.copyProperties(o,h);
                nl.add(h);
            }
        }
        j.setRows(nl);// 设置返回的行
        return j;
	}

	@Override
	public HealthInterface edit(HealthInterface healthInterface) {
		HealthInterface h=(HealthInterface) super.getBaseDao().get(HealthInterface.class, healthInterface.getId());
		BeanUtils.copyProperties(healthInterface, h);
		return healthInterface;
	}

	@Override
	public void delete(String ids) {
		for (String id : ids.split(",")) {
            if (id != null && !id.equals("")) {
            	HealthInterface h = (HealthInterface) super.getBaseDao().load(HealthInterface.class, id);
                super.getBaseDao().delete(h);
            }
        }
	}
}
