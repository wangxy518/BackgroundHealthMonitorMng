package HealthMonitorMng.dao;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public interface BaseDaoI {
	public Session getSession();

	public void save(Object o);

	public void update(Object o);

	public void saveOrUpdate(Object o);

	public void merge(Object o);

	public void delete(Object o);

	public List find(String hql, Object... param);

	public List find(String hql, List param);

	public List find(String hql, int page, int rows, List param);

	public List find(String hql, int page, int rows, Object... param);

	public Object get(Class c, Serializable id);

	public Object get(String hql, Object... param);

	public Object get(String hql, List param);

	public Object load(Class c, Serializable id);

	public Long count(String hql, Object... param);

	public Long count(String hql, List param);

	public int executeNonQuery(String hql);

	public Query createQuery(String hql);
	
	public List findByTime(String hql,Timestamp begin,Timestamp end,String userId);

}
