package HealthMonitorMng.service.background;

import java.util.List;

import HealthMonitorMng.hbm.base.HighWeight;
import HealthMonitorMng.model.DetectionPage;
import HealthMonitorMng.service.BaseServiceI;
public interface DetectionServiceI extends BaseServiceI{
	public List findByTime(DetectionPage detectionPage);
	public void add(Object entity);
	public Object getNewData(DetectionPage detectionPage);
	public void update(Object obj);
	public void delete(Object obj);
	public Object  getObjById(String id,Object obj);
}
