/**
 * QuestionFormulaServiceImpl.java
 * onesun.service.impl
 *
 * Function： TODO 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2015年3月14日 		DingMiangLiang
 *
 * Copyright (c) 2015, TNT All Rights Reserved.
 */

package HealthMonitorMng.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import HealthMonitorMng.hbm.base.QuestionFormula;
import HealthMonitorMng.model.DataGrid;
import HealthMonitorMng.model.DataGridJson;

import HealthMonitorMng.service.QuestionFormulaServiceI;

/**
 * ClassName:QuestionFormulaServiceImpl Function: TODO ADD FUNCTION Reason: TODO
 * ADD REASON
 *
 * @author DingMiangLiang
 * @version
 * @since Ver 1.1
 * @Date 2015年3月14日 上午11:20:51
 *
 * @see
 * 
 */
@Transactional
@Service("questionFormulaService")
public class QuestionFormulaServiceImpl extends BaseServiceImpl implements
		QuestionFormulaServiceI {

	/**
	 * (non-Javadoc)
	 * @see HealthMonitorMng.service.QuestionFormulaServiceI#datagrid(HealthMonitorMng.model.DataGrid, HealthMonitorMng.hbm.base.QuestionFormula)
	 */
	@Override
	public DataGridJson datagrid(DataGrid dg, QuestionFormula questionFormula) {

		DataGridJson j = new DataGridJson();
		String hql = " from QuestionFormula t where 1=1 ";
		List<Object> values = new ArrayList<Object>();
		String totalHql = " select count(*) " + hql;
		j.setTotal(super.getBaseDao().count(totalHql, values));// 设置总记录数
		if (dg.getSort() != null) {// 设置排序
			hql += " order by " + dg.getSort() + " " + dg.getOrder();
		}
		else
		{
			hql += " order by formulaKey desc ";
		}
		List<QuestionFormula> ol = super.getBaseDao().find(hql, dg.getPage(), dg.getRows(), values);// 查询分页
		j.setRows(ol);// 设置返回的行
		return j;

	}

	/**
	 * (non-Javadoc)
	 * @see HealthMonitorMng.service.QuestionFormulaServiceI#edit(HealthMonitorMng.hbm.base.QuestionFormula)
	 */
	@Override
	public QuestionFormula edit(QuestionFormula questionFormula) {
		QuestionFormula q = (QuestionFormula) super.getBaseDao().get(QuestionFormula.class, questionFormula.getId());
		BeanUtils.copyProperties(questionFormula, q);
		
		return questionFormula;
	}

	/**
	 * (non-Javadoc)
	 * @see HealthMonitorMng.service.QuestionFormulaServiceI#add(HealthMonitorMng.hbm.base.QuestionFormula)
	 */
	@Override
	public QuestionFormula add(QuestionFormula questionFormula) {
		questionFormula.setId(UUID.randomUUID().toString());
		super.getBaseDao().save(questionFormula);
		return questionFormula;

	}

}
