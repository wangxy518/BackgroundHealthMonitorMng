package HealthMonitorMng.service.impl.background;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import HealthMonitorMng.service.HomeServiceI;
import HealthMonitorMng.service.impl.BaseServiceImpl;


@Service("homeService")
@Transactional
public class HomeServiceImpl extends BaseServiceImpl implements HomeServiceI {

}
