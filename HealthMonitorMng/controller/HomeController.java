package HealthMonitorMng.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import HealthMonitorMng.service.HomeServiceI;


@Controller
@RequestMapping("/homeController")
public class HomeController extends BaseController {

	private HomeServiceI homeService;

	public HomeServiceI getHomeService() {
		return homeService;
	}

	@Autowired
	public void setHomeService(HomeServiceI homeService) {
		this.homeService = homeService;
	}

	@RequestMapping(params = "home")
	public String home() {
		return "admin/home";
	}

	@RequestMapping(params = "portal")
	public String portal() {
		return "layout/portal";
	}

}
