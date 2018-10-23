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

import HealthMonitorMng.hbm.base.background.DetectObject;
import HealthMonitorMng.hbm.base.background.BasicData.Area;
import HealthMonitorMng.hbm.base.background.BasicData.BasicData;
import HealthMonitorMng.hbm.base.background.BasicData.City;
import HealthMonitorMng.hbm.base.background.BasicData.Province;
import HealthMonitorMng.model.DataGrid;
import HealthMonitorMng.model.DataGridJson;
import HealthMonitorMng.model.Location;
import HealthMonitorMng.service.background.BasicDataServiceI;
import HealthMonitorMng.service.impl.BaseServiceImpl;
/** 
* @ClassName: BasicDataServiceImpl 
* @Description: 基础数据维护服务类
* @author WuHoushuang 
* @date 2015年2月4日 下午8:02:41 
*/
@Transactional
@Service("basicDataService")
public class BasicDataServiceImpl extends BaseServiceImpl implements BasicDataServiceI{

	/* 
	 * 实现基础数据维护的添加 
	* <p>Title: addBasicData</p> 
	* <p>Description: </p> 
	* @param basicData 基础数据类
	* @return  刚添加的基础数据类
	* @see onesun.service.background.BasicDataServiceI#addBasicData(onesun.hbm.base.background.BasicData.BasicData) 
	*/
	@Override
	public BasicData addBasicData(BasicData basicData) {
		basicData.setDataId(UUID.randomUUID().toString());
		BasicData basic=new BasicData();
		BeanUtils.copyProperties(basicData, basic);
		super.getBaseDao().save(basic);
		List<String> nameList=new ArrayList<String>();
		nameList.add(basicData.getDetectObject());
		String hql="From DetectObject where detectName=?";
		DetectObject detect=(DetectObject) super.getBaseDao().get(hql, nameList);
		if(detect==null){
			DetectObject detectObject=new DetectObject();
			detectObject.setDataId(UUID.randomUUID().toString());
			detectObject.setDetectName(basicData.getDetectObject());
			super.getBaseDao().save(detectObject);
		}
		return basicData;
	}

	@Override
	public DataGridJson datagrid(DataGrid dg, BasicData basicData) {
		 DataGridJson j = new DataGridJson();
	        String hql = " from BasicData t where 1=1 ";
	        List<Object> values = new ArrayList<Object>();
	        String totalHql = " select count(*) " + hql;
	        j.setTotal(super.getBaseDao().count(totalHql, values));// 设置总记录数
	        if (dg.getSort() != null) {// 设置排序
	            hql += " order by " + dg.getSort() + " " + dg.getOrder();
	        } else {
	            hql += " order by code desc ";
	        }
	        List<BasicData> ol = super.getBaseDao().find(hql, dg.getPage(), dg.getRows(), values);// 查询分页
	        List<BasicData> nl = new ArrayList<BasicData>();
	        if (ol != null && ol.size() > 0) {// 转换模型
	            for (BasicData o : ol) {
	            	BasicData basic = new BasicData();
	                BeanUtils.copyProperties(o,basic);
	                nl.add(basic);
	            }
	        }
	        j.setRows(nl);// 设置返回的行
	        return j;
	}

	@Override
	public BasicData edit(BasicData basicData) {
		BasicData bd=(BasicData) super.getBaseDao().get(BasicData.class, basicData.getDataId());
		BeanUtils.copyProperties(basicData, bd);//转换模型
		return basicData;
	}

	@Override
	public void delete(String ids) {
		for(String id: ids.split(",")){
			if(id!=null&&!"".equals(id)){
				BasicData bd=(BasicData) super.getBaseDao().load(BasicData.class, id);
				super.getBaseDao().delete(bd);
			}
		}
	}

	@Override
	public List<DetectObject> getDetectName() {
		String hql="From DetectObject";
		Query query=super.getBaseDao().createQuery(hql);
		List<DetectObject> detectObjects=query.list();
		return detectObjects;
	}

	@Override
	public List<Province> getProvinces() {
		String hql="From Province";
		Query query=super.getBaseDao().createQuery(hql);
		List<Province> provinces=query.list();
		return provinces;
	}

	@Override
	public List<City> getCities(String provinceid) {
		String hql="From City where provinceid=?";
		List<String> proList=new ArrayList<String>();
		proList.add(provinceid);
		List<City> cities=super.getBaseDao().find(hql, proList);
		return cities;
	}

	@Override
	public List<Area> getAreas(String cityid) {
		String hql="From Area where cityid=?";
		List<String> cityList=new ArrayList<String>();
		cityList.add(cityid);
		List<Area> areas=super.getBaseDao().find(hql, cityList);
		return areas;
	}

	@Override
	public Province getProvince(String provinceid) {
		System.out.println(provinceid);
		Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(provinceid);
        Province province=null;
        if(isNum.matches()){
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
		System.out.println(cityid);
		Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(cityid);
        City city=null;
        if(isNum.matches()){
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
	public BasicData getData(String rowId) {
		String hql="From BasicData where dataId=?";
		List<String> list=new ArrayList<String>();
		list.add(rowId);
		BasicData basicData=(BasicData) super.getBaseDao().get(hql, list);
		return basicData;
	}

}
