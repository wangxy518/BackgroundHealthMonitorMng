package HealthMonitorMng.service.impl.background;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import HealthMonitorMng.hbm.base.background.EquipHouse;
import HealthMonitorMng.hbm.base.background.Equipment;
import HealthMonitorMng.hbm.base.background.HealthHouse;
import HealthMonitorMng.hbm.base.background.Version;
import HealthMonitorMng.model.DataGrid;
import HealthMonitorMng.model.DataGridJson;
import HealthMonitorMng.service.background.VersionServiceI;
import HealthMonitorMng.service.impl.BaseServiceImpl;

@Transactional
@Service("versionService")
public class VersionServiceImpl extends BaseServiceImpl implements VersionServiceI{

	@Override
	public Version addVersion(Version version) {
		version.setId(UUID.randomUUID().toString());
		Version v=new Version();
		BeanUtils.copyProperties(version, v);
		super.getBaseDao().save(v);
		return version;
	}

	@Override
	public DataGridJson datagrid(DataGrid dg, Version version) {
		DataGridJson j = new DataGridJson();
        String hql = " from Version t where 1=1 ";
        List<Object> values = new ArrayList<Object>();
        String totalHql = " select count(*) " + hql;
        j.setTotal(super.getBaseDao().count(totalHql, values));// 设置总记录数
        if (dg.getSort() != null) {// 设置排序
            hql += " order by " + dg.getSort() + " " + dg.getOrder();
        } else {
            hql += " order by version desc ";
        }
        List<Version> ol = super.getBaseDao().find(hql, dg.getPage(), dg.getRows(), values);// 查询分页
        List<Version> nl = new ArrayList<Version>();
        if (ol != null && ol.size() > 0) {// 转换模型
            for (Version o : ol) {
            	Version v = new Version();
                BeanUtils.copyProperties(o,v);
                nl.add(v);
            }
        }
        j.setRows(nl);// 设置返回的行
        return j;
	}

	@Override
	public Version edit(Version version) {
		Version v=(Version) super.getBaseDao().get(Version.class, version.getId());
		BeanUtils.copyProperties(version, v);
		return version;
	}

	@Override
	public void delete(String ids) {
		for (String id : ids.split(",")) {
            if (id != null && !id.equals("")) {
            	Version v = (Version) super.getBaseDao().load(Version.class, id);
                super.getBaseDao().delete(v);
            }
        }
		
	}


}
