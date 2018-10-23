package HealthMonitorMng.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import HealthMonitorMng.dao.BaseDaoI;
import HealthMonitorMng.service.BaseServiceI;


@Service("baseService")
@Transactional
public class BaseServiceImpl implements BaseServiceI {

	private BaseDaoI baseDao;

	public BaseDaoI getBaseDao() {
		return baseDao;
	}

	@Autowired
	public void setBaseDao(BaseDaoI baseDao) {
		this.baseDao = baseDao;
	}

}
