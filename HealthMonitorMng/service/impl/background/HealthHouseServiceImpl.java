package HealthMonitorMng.service.impl.background;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.Query;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import HealthMonitorMng.hbm.base.background.EquipHouse;
import HealthMonitorMng.hbm.base.background.HealthHouse;
import HealthMonitorMng.hbm.base.background.BasicData.Area;
import HealthMonitorMng.hbm.base.background.BasicData.City;
import HealthMonitorMng.hbm.base.background.BasicData.Province;
import HealthMonitorMng.model.DataGrid;
import HealthMonitorMng.model.DataGridJson;
import HealthMonitorMng.service.background.HealthHouseServiceI;
import HealthMonitorMng.service.impl.BaseServiceImpl;
@Transactional
@Service("healthHouseService")
public class HealthHouseServiceImpl extends BaseServiceImpl implements HealthHouseServiceI{

	@Override
	public HealthHouse add(HealthHouse healthHouse) {
		healthHouse.setDataId(UUID.randomUUID().toString());
		HealthHouse hh=new HealthHouse();
		BeanUtils.copyProperties(healthHouse, hh);
		super.getBaseDao().save(hh);
		EquipHouse eh=new EquipHouse();
		eh.setHouseId(hh.getDataId());
		super.getBaseDao().save(eh);
		return healthHouse;
	}

	@Override
	public DataGridJson datagrid(DataGrid dg, HealthHouse healthHouse) {
		 DataGridJson j = new DataGridJson();
	        String hql = " from HealthHouse t where 1=1 ";
	        List<Object> values = new ArrayList<Object>();
	        if (healthHouse != null) {// 添加查询条件
	            if (healthHouse.getHouseName()!=null) {
	                hql += " and houseName like '%%" + healthHouse.getHouseName() + "%%' ";
	            }
	        }
	        String totalHql = " select count(*) " + hql;
	        j.setTotal(super.getBaseDao().count(totalHql, values));// 设置总记录数
	        if (dg.getSort() != null) {// 设置排序
	            hql += " order by " + dg.getSort() + " " + dg.getOrder();
	        } else {
	            hql += " order by houseNumber desc ";
	        }
	        List<HealthHouse> ol = super.getBaseDao().find(hql, dg.getPage(), dg.getRows(), values);// 查询分页
	        List<HealthHouse> nl = new ArrayList<HealthHouse>();
	        if (ol != null && ol.size() > 0) {// 转换模型
	            for (HealthHouse o : ol) {
	            	HealthHouse e = new HealthHouse();
	                BeanUtils.copyProperties(o,e);
	                nl.add(e);
	            }
	        }
	        j.setRows(nl);// 设置返回的行
	        return j;
	}

	@Override
	public HealthHouse edit(HealthHouse healthHouse) {
		HealthHouse hh=(HealthHouse) super.getBaseDao().get(HealthHouse.class, healthHouse.getDataId());
		BeanUtils.copyProperties(healthHouse, hh);
		return healthHouse;
	}

	@Override
	public void delete(String ids) {
		for (String id : ids.split(",")) {
            if (id != null && !id.equals("")) {
            	HealthHouse c = (HealthHouse) super.getBaseDao().load(HealthHouse.class, id);
                super.getBaseDao().delete(c);
            }
        }
	}

	@Override
	public List<HealthHouse> getLocation() {
		String hql="from HealthHouse";
		Query query=super.getBaseDao().createQuery(hql);
		List<HealthHouse> hh=query.list();
		return hh;
	}

	@Override
	public Province getProvince(String provinceid) {
		Pattern p=Pattern.compile("[0-9]*");
		Matcher m=p.matcher(provinceid);
		Province province=null;
		if(m.matches()){
			String hql="From Province where provinceid=?";
			List<String> list=new ArrayList<String>();
			list.add(provinceid);
			province=(Province) super.getBaseDao().get(hql, list);
		}else{
			String hql="From Province where province=?";
			List<String> list=new ArrayList<String>();
			list.add(provinceid);
			province=(Province) super.getBaseDao().get(hql, list);
		}
		return province;
	}

	@Override
	public City getCity(String cityid) {
		Pattern p=Pattern.compile("[0-9]*");
		Matcher m=p.matcher(cityid);
		City city=null;
		if(m.matches()){
			String hql="From City where cityid=?";
			List<String> list=new ArrayList<String>();
			list.add(cityid);
			city=(City) super.getBaseDao().get(hql, list);
		}else{
			String hql="From City where city=?";
			List<String> list=new ArrayList<String>();
			list.add(cityid);
			city=(City) super.getBaseDao().get(hql, list);
		}
		if("市".equals(city.getCity())||"市辖区".equals(city.getCity())||"县".equals(city.getCity())
				||"香港特别行政区".equals(city.getCity())||"澳门特别行政区".equals(city.getCity())){
			city.setCity("");
		}
		return city;
	}

	@Override
	public Area getArea(String areaid) {
		Pattern p=Pattern.compile("[0-9]*");
		Matcher m=p.matcher(areaid);
		Area area=null;
		if(m.matches()){
			String hql="From Area where areaid=?";
			List<String> list=new ArrayList<String>();
			list.add(areaid);
			area=(Area) super.getBaseDao().get(hql, list);	
		}else{
			String hql="From Area where area=?";
			List<String> list=new ArrayList<String>();
			list.add(areaid);
			area=(Area) super.getBaseDao().get(hql, list);	
		}
		if("香港特别行政区".equals(area.getArea())||"澳门特别行政区".equals(area.getArea())){
			area.setArea("");
		}
		return area;
	}

	@Override
	public HealthHouse getData(String rowId) {
		String hql="FROM HealthHouse WHERE dataId=?";
		List<String> list=new ArrayList<String>();
		list.add(rowId);
		HealthHouse healthHouse=(HealthHouse) super.getBaseDao().get(hql, list);
		return healthHouse;
	}


}
