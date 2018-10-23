package HealthMonitorMng.dao.impl;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import HealthMonitorMng.dao.BaseDaoI;

@Repository("baseDao")
public class BaseDaoImpl implements BaseDaoI {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public int executeNonQuery(String hql) {
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.executeUpdate();
	}

	@Override
	public void save(Object o) {
		this.getCurrentSession().save(o);
	}

	@Override
	public void update(Object o) {
		this.getCurrentSession().update(o);
	}

	@Override
	public void saveOrUpdate(Object o) {
		this.getCurrentSession().saveOrUpdate(o);
	}

	@Override
	public void merge(Object o) {
		this.getCurrentSession().merge(o);
	}

	@Override
	public void delete(Object o) {
		this.getCurrentSession().delete(o);
	}

	@Override
	public List find(String hql, List param) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return q.list();
	}

	@Override
	public List find(String hql, Object... param) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return q.list();
	}

	@Override
	public List find(String hql, int page, int rows, List param) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}

	/**
	 * 分页 多参数（参数不一样）
	 * */
	@Override
	public List find(String hql, int page, int rows, Object... param) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}

	@Override
	public Object get(Class c, Serializable id) {
		return this.getCurrentSession().get(c, id);
	}

	@Override
	public Object get(String hql, Object... param) {
		List l = this.find(hql, param);
		if (l != null && l.size() > 0) {
			return l.get(0);
		}
		return null;
	}

	@Override
	public Object get(String hql, List param) {
		List l = this.find(hql, param);
		if (l != null && l.size() > 0) {
			return l.get(0);
		}
		return null;
	}

	@Override
	public Object load(Class c, Serializable id) {
		return this.getCurrentSession().load(c, id);
	}

	@Override
	public Long count(String hql, Object... param) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return (Long) q.uniqueResult();
	}

	@Override
	public Long count(String hql, List param) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return (Long) q.uniqueResult();
	}

	public Query createQuery(String hql) {
		Query q = this.getCurrentSession().createQuery(hql);
		System.out.println(q);
		return q;
	}
    /**
     * 时间条件的hql  输入开始结束时间  在hql中是这种参数  :beginTime :endTime
     * */
	@Override
	public List findByTime(String hql,Timestamp begin,Timestamp
			end, String userID) {
		Query q = this.getCurrentSession().createQuery(hql);
		q.setParameter("userID", userID);
//		q.setParameter("sortType", sortType);
		q.setTimestamp("beginTime", begin);
		q.setTimestamp("endTime", end);
		return q.list();
	}
}
