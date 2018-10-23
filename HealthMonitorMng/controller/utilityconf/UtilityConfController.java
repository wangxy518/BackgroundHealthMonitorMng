package HealthMonitorMng.controller.utilityconf;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import HealthMonitorMng.hbm.configEntity.UtilityConfig;
import HealthMonitorMng.model.AjaxJson;
import HealthMonitorMng.model.DataGrid;
import HealthMonitorMng.model.DataGridJson;
import HealthMonitorMng.service.background.CustomUserUtilityConfServiceI;

/**@anthor Brave Han*/
@Controller
@RequestMapping("/utility_conf")
public class UtilityConfController {

	@Autowired
	private CustomUserUtilityConfServiceI serviceI;
	
	@RequestMapping(params="init")
	public String init(){
		return "view/utility/utility";
	}
	@RequestMapping(params="add_init")
	public String addinit(){
		return "admin/utility/addutility";
	}
	
	@RequestMapping(params="index")
	public String index(){
		return "admin/utility/index";
	}
	
	@RequestMapping(params = "datagrid")
	@ResponseBody
	public DataGridJson datagrid(DataGrid dg) {
		DataGridJson DG = serviceI.datagrid(dg);
		return DG;
	}
	@RequestMapping(params = "delete")
	@ResponseBody
	public AjaxJson delete(String ids) {
		AjaxJson aj = new AjaxJson();
		try{
			serviceI.delete(ids);
			aj.setMsg("删除成功");
			aj.setSuccess(true);
		}catch(Exception e){
			aj.setSuccess(false);
			aj.setMsg("删除失败");
		}
		return aj;
	}
	
	
	
	@Transactional
	@ResponseBody
	@RequestMapping(params="list")
	public AjaxJson getList(){
		List<UtilityConfig> list=new ArrayList<UtilityConfig>();
		list=serviceI.getList();
		AjaxJson t;
		if(list.size()==0){
			t=new AjaxJson(false,"error",null);
		}else{
			t=new AjaxJson(true, "success", list);
		}
		return t;
	}
	@ResponseBody
	@RequestMapping(params="add")
	public boolean add(@RequestParam("formula")String str,
			                       @RequestParam("formulaNum")Integer num,
			                       @RequestParam("jsonData")String jsonData,
			                       @RequestParam("utilType")String utilType,
			                       @RequestParam("explain") String explain,
			                       @RequestParam("resultUnit") String resultUnit){
		try{
		UtilityConfig uc=new UtilityConfig();
		uc.setFormula(str);
		uc.setOperationAdmin(resultUnit);
		uc.setFormulaNum(num);
		uc.setJsonData(jsonData);
		uc.setUtilType(utilType);
		uc.setFlag(explain);
		serviceI.addOne(uc);
		}catch(Exception e){
			return false;
		}
		return true;
	}
}
