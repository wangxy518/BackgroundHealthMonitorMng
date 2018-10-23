package HealthMonitorMng.service.impl.background;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hibernate.Query;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import HealthMonitorMng.hbm.base.background.EquipHouse;
import HealthMonitorMng.hbm.base.background.Equipment;
import HealthMonitorMng.hbm.base.background.EquipmentImage;
import HealthMonitorMng.hbm.base.background.HealthHouse;
import HealthMonitorMng.model.DataGrid;
import HealthMonitorMng.model.DataGridJson;
import HealthMonitorMng.service.background.EquipmentServiceI;
import HealthMonitorMng.service.impl.BaseServiceImpl;
@Transactional
@Service("equipmentService")
public class EquipmentServiceImpl extends BaseServiceImpl implements EquipmentServiceI{
	
	
	@Override
	public Equipment addEquipment(Equipment equipment) {
		equipment.setDataId(UUID.randomUUID().toString());
		Equipment e=new Equipment();
		BeanUtils.copyProperties(equipment, e);
		super.getBaseDao().save(e);
		EquipHouse eh=new EquipHouse();
		eh.setDataId(UUID.randomUUID().toString());
		eh.setEquipId(equipment.getDataId());
		String hql="from HealthHouse where houseName=?";
		List<String> nameList=new ArrayList<String>();
		nameList.add(equipment.getBelongLocation());
		HealthHouse hh=(HealthHouse) super.getBaseDao().get(hql, nameList);
		if(hh==null){
			eh.setDataId(UUID.randomUUID().toString());
		}else{
		eh.setHouseId(hh.getDataId());
		}
		super.getBaseDao().save(eh);
		return equipment;
	}
	
	@Override
	public EquipmentImage addImage(EquipmentImage equipmentImage) {
		equipmentImage.setDataId(UUID.randomUUID().toString());
		EquipmentImage e=new EquipmentImage();
		Equipment equipment=(Equipment) super.getBaseDao().get(Equipment.class, equipmentImage.getEquipmentId());
		equipmentImage.setEquipment(equipment);
		BeanUtils.copyProperties(equipmentImage, e);
		super.getBaseDao().save(e);
		return equipmentImage;
	}

	@Override
	public DataGridJson datagrid(DataGrid dg, Equipment equipment) {
		 DataGridJson j = new DataGridJson();
	        String hql = " from Equipment t inner join t.healthHouses h where 1=1 ";
	        List<Object> values = new ArrayList<Object>();
	        System.out.println(equipment);
	        if (equipment != null) {// 添加查询条件
	        	if(equipment.getBelongLocation()!=null){
	        		 hql += " and h.houseName like '%%" + equipment.getBelongLocation() + "%%' ";
	        	}
	        }
	        String totalHql = " select count(*) " + hql;
	        j.setTotal(super.getBaseDao().count(totalHql, values));// 设置总记录数
	        if (dg.getSort() != null) {// 设置排序
	            hql += " order by t." + dg.getSort() + " " + dg.getOrder();
	        } else {
	            hql += " order by t.equipmentNumber desc ";
	        }
	        List<Equipment> ol = super.getBaseDao().find("select t "+hql, dg.getPage(), dg.getRows(), values);// 查询分页
	        List<Equipment> nl = new ArrayList<Equipment>();
	        if (ol != null && ol.size() > 0) {// 转换模型
	            for (Equipment o : ol) {
	            	Equipment e = new Equipment();
	                BeanUtils.copyProperties(o,e);
	                nl.add(e);
	            }
	        }
	        j.setRows(nl);// 设置返回的行
	        return j;
	}
	
	public DataGridJson datagridForImage(DataGrid dg, Equipment equipment) {
		 DataGridJson j = new DataGridJson();
//	        String hql = " from Equipment t,t.healthHouses h where 1=1 ";
		 	String hql = " from Equipment t inner join t.healthHouses h inner join t.equipmentImage i ";
	        List<Object> values = new ArrayList<Object>();
//	        if (equipment != null) {// 添加查询条件
//	        	if(equipment.getBelongLocation()!=null){
//	        		 hql += " and h.houseName like '%%" + equipment.getBelongLocation() + "%%' ";
//	        	}
//	        }
	        String totalHql = " select count(*) " + hql;
	        j.setTotal(super.getBaseDao().count(totalHql, values));// 设置总记录数
	        if (dg.getSort() != null) {// 设置排序
	            hql += " order by t." + dg.getSort() + " " + dg.getOrder();
	        } else {
	            hql += " order by t.equipmentNumber desc ";
	        }
	        List<EquipmentImage> ol = super.getBaseDao().find("select i "+hql, dg.getPage(), dg.getRows(), values);// 查询分页
	        List<EquipmentImage> nl = new ArrayList<EquipmentImage>();
//	        Equipment e ;
//	        if (ol != null && ol.size() > 0) {// 转换模型
//	            for (Equipment o : ol) {
//	            	for (EquipmentImage ei : o.getEquipmentImage()) {
//	            		e = new Equipment();
//	            		e.setEquipmentImage(o.getEquipmentImage());
//	            		e.getEquipmentImage().clear();
//	            		e.getEquipmentImage().add(ei);
//		                nl.add(e);
//	            	}
//	            }
//	        }
	      if (ol != null && ol.size() > 0) {// 转换模型
	            for (EquipmentImage o : ol) {
	            	EquipmentImage e = new EquipmentImage();
	            	BeanUtils.copyProperties(o,e);
	                nl.add(e);
	            }
	        }
	        j.setRows(nl);// 设置返回的行
	        return j;
	}
	
	@Override
	public List<Equipment> getEquipments(String houseId) {
		String hql="select t from Equipment t inner join t.healthHouses h where h.dataId = ? ";
		List<String> nameList=new ArrayList<String>();
		nameList.add(houseId);
		List<Equipment> e= super.getBaseDao().find(hql, nameList);
		return e;
	}

	@Override
	public Equipment edit(Equipment equipment) {
		//Equipment e=(Equipment) super.getBaseDao().get(Equipment.class, equipment.getDataId());
		//BeanUtils.copyProperties(equipment, e);
		super.getBaseDao().saveOrUpdate(equipment);
		super.getBaseDao().getSession().flush();
		String hql="from HealthHouse where houseName=?";
		List<String> nameList=new ArrayList<String>();
		nameList.add(equipment.getBelongLocation());
		HealthHouse hh=(HealthHouse) super.getBaseDao().get(hql, nameList);
		String houseId = hh.getDataId();
		EquipHouse eh = new EquipHouse();
		eh.setHouseId(houseId);
		eh.setEquipId(equipment.getDataId());
		eh.setDataId(UUID.randomUUID().toString());
		super.getBaseDao().save(eh);
		return equipment;
	}
	
	@Override
	public EquipmentImage editImage(EquipmentImage equipmentImage) {
		//Equipment e=(Equipment) super.getBaseDao().get(Equipment.class, equipment.getDataId());
		//BeanUtils.copyProperties(equipment, e);
		super.getBaseDao().saveOrUpdate(equipmentImage);
		super.getBaseDao().getSession().flush();

		return equipmentImage;
	}

	@Override
	public void delete(String ids) {
		for (String id : ids.split(",")) {
            if (id != null && !id.equals("")) {
            	Equipment c = (Equipment) super.getBaseDao().load(Equipment.class, id);
                super.getBaseDao().delete(c);
            }
        }
	}

	@Override
	public void deleteImage(String ids) {
		for (String id : ids.split(",")) {
            if (id != null && !id.equals("")) {
            	EquipmentImage e = (EquipmentImage) super.getBaseDao().load(EquipmentImage.class, id);
                super.getBaseDao().delete(e);
            }
        }
	}
}
