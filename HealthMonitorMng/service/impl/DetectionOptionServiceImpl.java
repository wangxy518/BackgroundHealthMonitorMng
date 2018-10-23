/**
 * DetectionOptionServiceImpl.java
 * onesun.service.impl
 *
 * Function： TODO 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2015年3月14日 		DingMingliang
 *
 * Copyright (c) 2015, TNT All Rights Reserved.
 */

package HealthMonitorMng.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.activiti.engine.impl.util.json.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;

import HealthMonitorMng.hbm.base.DetectionOption;
import HealthMonitorMng.hbm.base.background.Department;
import HealthMonitorMng.model.DataGrid;
import HealthMonitorMng.model.DataGridJson;
import HealthMonitorMng.model.DepartmentModel;
import HealthMonitorMng.model.DetectionOptionJson;
import HealthMonitorMng.model.DetectionOptionModel;
import HealthMonitorMng.service.DetectionOptionServiceI;

/**
 * ClassName:DetectionOptionServiceImpl Function: TODO ADD FUNCTION Reason: TODO
 * ADD REASON
 *
 * @author DingMingliang
 * @version
 * @since Ver 1.1
 * @Date 2015年3月14日 下午3:16:41
 *
 * @see
 * 
 */
@Transactional
@Service("detectionOptionService")
public class DetectionOptionServiceImpl extends BaseServiceImpl implements
		DetectionOptionServiceI {
	public static <T> T getJsonBean(String jsonString, Class<T> cls) {  
        T t = null;  
        try {  
            t = JSON.parseObject(jsonString, cls);  
        } catch (Exception e) {  
            // TODO: handle exception  
            e.printStackTrace();  
        }  
        return t;  
    }  
	@Override
	public DataGridJson datagrid(DataGrid dg,
			DetectionOptionModel detectionOption) {
		DataGridJson j = new DataGridJson();
		String hql = " from DetectionOption t where 1=1 ";
		List<Object> values = new ArrayList<Object>();
		String totalHql = " select count(*) " + hql;
		j.setTotal(super.getBaseDao().count(totalHql, values));// 设置总记录数
		if (dg.getSort() != null) {// 设置排序
			hql += " order by " + dg.getSort() + " " + dg.getOrder();
		} else {
			hql += " order by keyRt desc ";
		}
		List<DetectionOption> ol = super.getBaseDao().find(hql, dg.getPage(),
				dg.getRows(), values);// 查询分页
		List<DetectionOptionModel> nl = new ArrayList<DetectionOptionModel>();
		if (ol != null && ol.size() > 0) {// 转换模型
			for (DetectionOption o : ol) {
				DetectionOptionModel n = new DetectionOptionModel();
				DetectionOptionJson m = (DetectionOptionJson)JSON.parseObject(o.getResult(), DetectionOptionJson.class);
				BeanUtils.copyProperties(o, n);
				n.setMax( m.getMax());
				n.setMin(m.getMin());
				n.setNmlx(m.getNmlx());
				n.setNmln(m.getNmln());
				nl.add(n);
			}
		}
		j.setRows(nl);// 设置返回的行
		return j;

	}

	@Override
	public DetectionOptionModel add(DetectionOptionModel detectionOption) {

		// TODO Auto-generated method stub
		return null;

	}

	@Override
	public DetectionOptionModel edit(DetectionOptionModel detectionOption) {
		DetectionOptionJson m = new DetectionOptionJson();
		if(detectionOption.getMax()!=null && !"".equals(detectionOption.getMax())){
			m.setMax(detectionOption.getMax());
		}else{
			m.setMax("0");
		}
		if(detectionOption.getMin()!=null && !"".equals(detectionOption.getMin())){
			m.setMin(detectionOption.getMin());
		}else{
			m.setMin("0");
		}
		if(detectionOption.getNmlx()!=null && !"".equals(detectionOption.getNmlx())){
			m.setNmlx(detectionOption.getNmlx());
		}else{
			m.setNmlx("0");
		}
		if(detectionOption.getNmln()!=null && !"".equals(detectionOption.getNmln())){
			m.setNmln(detectionOption.getNmln());
		}else{
			m.setNmln("0");
		}
		DetectionOption d = new DetectionOption();
		BeanUtils.copyProperties(detectionOption, d);
		d.setResult(JSON.toJSONString(m));
		d.setFlag("1");
		super.getBaseDao().update(d);
		return detectionOption;

	}

	@Override
	public void delete(String ids) {

		// TODO Auto-generated method stub

	}

}
