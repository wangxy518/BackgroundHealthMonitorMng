package HealthMonitorMng.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import HealthMonitorMng.hbm.base.QuestionFormula;
import HealthMonitorMng.model.AjaxJson;
import HealthMonitorMng.model.ChartJson;
import HealthMonitorMng.model.DataGrid;
import HealthMonitorMng.model.DataGridJson;
import HealthMonitorMng.model.DepartmentModel;
import HealthMonitorMng.model.SportsCondition;
import HealthMonitorMng.service.QuestionFormulaServiceI;
import HealthMonitorMng.service.background.DepartmentServiceI;
import HealthMonitorMng.util.CustomDateEditor;

/**
 * @ClassName: DepartmentController
 * @Description: 公式控制器
 * @author DingMingliang
 * @date 2015年3月11日
 */
@Controller
@RequestMapping("/admin/questionFormulaController")
public class QuestionFormulaController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger
			.getLogger(QuestionFormulaController.class);

	private QuestionFormulaServiceI questionFormulaService;

	/**
	 * questionFormulaService
	 *
	 * @return the questionFormulaService
	 * @since CodingExample Ver 1.0
	 */

	public QuestionFormulaServiceI getQuestionFormulaService() {
		return questionFormulaService;
	}

	/**
	 * questionFormulaService
	 *
	 * @param questionFormulaService
	 *            the questionFormulaService to set
	 * @since CodingExample Ver 1.0
	 */
	@Autowired
	public void setQuestionFormulaService(
			QuestionFormulaServiceI questionFormulaService) {
		this.questionFormulaService = questionFormulaService;
	}

	/**
	 * index:后台功能页面跳转到首页 仅在后台easy-ui中做跳转使用
	 *
	 * @param @return 返回jsp地址
	 * @return String DOM对象
	 * @throws
	 * @since CodingExample　Ver 1.1
	 */
	@RequestMapping(params = "index")
	public String index() {
		return "admin/questionFormula/index";
	}

	/**
	 * datagrid:后台面板
	 *
	 * @param @param dg
	 * @param @param questionFormula
	 * @param @return 设定文件
	 * @return DataGridJson DOM对象
	 * @throws
	 * @since CodingExample　Ver 1.1
	 */
	@RequestMapping(params = "datagrid")
	@ResponseBody
	public DataGridJson datagrid(DataGrid dg, QuestionFormula questionFormula) {
		return questionFormulaService.datagrid(dg, questionFormula);
	}

	/**
	 * add:　添加
	 *
	 * @param @param request
	 * @param @param questionFormula
	 * @param @return 设定文件
	 * @return AjaxJson DOM对象
	 * @throws
	 * @since CodingExample　Ver 1.1
	 */
	@RequestMapping(params = "add")
	@ResponseBody
	public AjaxJson add(HttpServletRequest request,
			QuestionFormula questionFormula) {
		AjaxJson j = new AjaxJson();
		try {
			questionFormulaService.add(questionFormula);
			j.setSuccess(true);
			j.setMsg("添加成功！");
		} catch (Exception e) {
			j.setMsg("添加失败！");
		}
		return j;
	}

	/**
	 * edit:编辑
	 *
	 * @param @param request
	 * @param @param questionFormula
	 * @param @return 设定文件
	 * @return AjaxJson DOM对象
	 * @throws
	 * @since CodingExample　Ver 1.1
	 */
	@RequestMapping(params = "edit")
	@ResponseBody
	public AjaxJson edit(HttpServletRequest request,
			QuestionFormula questionFormula) {
		AjaxJson j = new AjaxJson();
		try {
			questionFormulaService.edit(questionFormula);
			j.setSuccess(true);
			j.setMsg("编辑成功！");
		} catch (Exception e) {
			j.setMsg("编辑失败！");
		}
		return j;
	}

	@InitBinder
	public void initBinder(ServletRequestDataBinder binder) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));
	}
}
