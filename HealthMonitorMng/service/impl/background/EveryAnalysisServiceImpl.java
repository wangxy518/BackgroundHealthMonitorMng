package HealthMonitorMng.service.impl.background;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import HealthMonitorMng.hbm.base.LatestAssessmentResult;
import HealthMonitorMng.hbm.base.background.NameResult;
import HealthMonitorMng.service.background.EveryAnalysisServiceI;
import HealthMonitorMng.service.impl.BaseServiceImpl;
import HealthMonitorMng.util.AssessAnalysisUtil;
@Transactional
@Service("everyAnalysisService")
public class EveryAnalysisServiceImpl extends BaseServiceImpl implements EveryAnalysisServiceI{

	@Override
	public List<NameResult> getEveryAnalysisResult(String everyAssessment) throws Exception {
		String hql="SELECT DISTINCT userId FROM LatestAssessmentResult";
		Query q=super.getBaseDao().createQuery(hql);
		List<String> list=q.list();
		List<String> dataResult=new ArrayList<String>();
		for(int i=0;i<list.size();i++){
			List<String> userList=new ArrayList<String>();
			userList.add(list.get(i));
			String userHql="From LatestAssessmentResult where userId=? ORDER BY evaluate DESC";
			List<LatestAssessmentResult> results=super.getBaseDao().find(userHql,1,1,userList);
			LatestAssessmentResult assessmentResult=results.get(0);
			if("BMI".equals(everyAssessment)&&assessmentResult.getBmiResultFlag()!=null){
				dataResult.add(assessmentResult.getBmiResultFlag());
			}
			if("fat".equals(everyAssessment)&&assessmentResult.getFatResultFlag()!=null){
				dataResult.add(assessmentResult.getFatResultFlag());
			}
			if("fatRate".equals(everyAssessment)&&assessmentResult.getFatRateResultFlag()!=null){
				dataResult.add(assessmentResult.getFatRateResultFlag());
			}
			if("pressure".equals(everyAssessment)&&assessmentResult.getPressureResultFlag()!=null){
				dataResult.add(assessmentResult.getPressureResultFlag());
			}
			if("sugar".equals(everyAssessment)&&assessmentResult.getSugarResultFlag()!=null){
				dataResult.add(assessmentResult.getSugarResultFlag());
			}
			if("atery".equals(everyAssessment)&&assessmentResult.getAteryResultFlag()!=null){
				dataResult.add(assessmentResult.getAteryResultFlag());
			}
			if("metabolic".equals(everyAssessment)&&assessmentResult.getMetabolicResultFlag()!=null){
				dataResult.add(assessmentResult.getMetabolicResultFlag());
			}
			if("waistline".equals(everyAssessment)&&assessmentResult.getWaistlineResultFlag()!=null){
				dataResult.add(assessmentResult.getWaistlineResultFlag());
			}
			if("waistHeight".equals(everyAssessment)&&assessmentResult.getWaistHeightResultFlag()!=null){
				dataResult.add(assessmentResult.getWaistHeightResultFlag());
			}
			if("risk".equals(everyAssessment)&&assessmentResult.getRiskResultFlag()!=null){
				dataResult.add(assessmentResult.getRiskResultFlag());
			}
		}
		List<NameResult> resultDouble=new ArrayList<NameResult>();
		Map<String, Double> resultMap=AssessAnalysisUtil.getAnalysisResult(dataResult);
		if("BMI".equals(everyAssessment)){
			Iterator<Map.Entry<String, Double>> it = resultMap.entrySet().iterator();  
	        while(it.hasNext()){  
	            Map.Entry<String, Double> entry=it.next();  
	            String key=entry.getKey();  
	            if("fivePrecent".equals(key)){  
	                it.remove();    
	            }  
	        } 
	        Set<String> keys=resultMap.keySet();
			for(String key:keys){
				NameResult nameResult=new NameResult();
				if("onePrecent".equals(key)){
					nameResult=(NameResult) nameResult.clone();
					nameResult.setName("体重过低");
					nameResult.setResult(resultMap.get(key));
					resultDouble.add(nameResult);
				}
				if("twoPrecent".equals(key)){
					nameResult=(NameResult) nameResult.clone();
					nameResult.setName("正常");
					nameResult.setResult(resultMap.get(key));
					resultDouble.add(nameResult);
				}
				if("threePrecent".equals(key)){
					nameResult=(NameResult) nameResult.clone();
					nameResult.setName("超重");
					nameResult.setResult(resultMap.get(key));
					resultDouble.add(nameResult);
				}
				if("fourPrecent".equals(key)){
					nameResult=(NameResult) nameResult.clone();
					nameResult.setName("肥胖");
					nameResult.setResult(resultMap.get(key));
					resultDouble.add(nameResult);
				}
			}
		}
		if("sugar".equals(everyAssessment)){
			Iterator<Map.Entry<String, Double>> it = resultMap.entrySet().iterator();  
	        while(it.hasNext()){  
	            Map.Entry<String, Double> entry=it.next();  
	            String key=entry.getKey();  
	            if("fivePrecent".equals(key)){  
	                it.remove();    
	            }  
	        } 
	        Set<String> keys=resultMap.keySet();
			for(String key:keys){
				NameResult nameResult=new NameResult();
				if("onePrecent".equals(key)){
					nameResult=(NameResult) nameResult.clone();
					nameResult.setName("正常");
					nameResult.setResult(resultMap.get(key));
					resultDouble.add(nameResult);
				}
				if("twoPrecent".equals(key)){
					nameResult=(NameResult) nameResult.clone();
					nameResult.setName("空腹血糖受损");
					nameResult.setResult(resultMap.get(key));
					resultDouble.add(nameResult);
				}
				if("threePrecent".equals(key)){
					nameResult=(NameResult) nameResult.clone();
					nameResult.setName("糖耐量减低");
					nameResult.setResult(resultMap.get(key));
					resultDouble.add(nameResult);
				}
				if("fourPrecent".equals(key)){
					nameResult=(NameResult) nameResult.clone();
					nameResult.setName("高血糖");
					nameResult.setResult(resultMap.get(key));
					resultDouble.add(nameResult);
				}
				}
			}
		if("waistline".equals(everyAssessment)){
			Iterator<Map.Entry<String, Double>> it = resultMap.entrySet().iterator();  
	        while(it.hasNext()){  
	            Map.Entry<String, Double> entry=it.next();  
	            String key=entry.getKey();  
	            if("fivePrecent".equals(key)){  
	                it.remove();    
	            }
	            if("fourPrecent".equals(key)){
	            	it.remove();
	            }
	        } 
	        Set<String> keys=resultMap.keySet();
			for(String key:keys){
				NameResult nameResult=new NameResult();
				if("onePrecent".equals(key)){
					nameResult=(NameResult) nameResult.clone();
					nameResult.setName("正常");
					nameResult.setResult(resultMap.get(key));
					resultDouble.add(nameResult);
				}
				if("twoPrecent".equals(key)){
					nameResult=(NameResult) nameResult.clone();
					nameResult.setName("中心性肥胖1度");
					nameResult.setResult(resultMap.get(key));
					resultDouble.add(nameResult);
				}
				if("threePrecent".equals(key)){
					nameResult=(NameResult) nameResult.clone();
					nameResult.setName("中心性肥胖2度");
					nameResult.setResult(resultMap.get(key));
					resultDouble.add(nameResult);
				}
				}
			}
		if("fatRate".equals(everyAssessment)){
			Iterator<Map.Entry<String, Double>> it = resultMap.entrySet().iterator();  
	        while(it.hasNext()){  
	            Map.Entry<String, Double> entry=it.next();  
	            String key=entry.getKey();  
	            if("fivePrecent".equals(key)){  
	                it.remove();    
	            }
	            if("fourPrecent".equals(key)){
	            	it.remove();
	            }
	        } 
	        Set<String> keys=resultMap.keySet();
			for(String key:keys){
				NameResult nameResult=new NameResult();
				if("onePrecent".equals(key)){
					nameResult=(NameResult) nameResult.clone();
					nameResult.setName("正常");
					nameResult.setResult(resultMap.get(key));
					resultDouble.add(nameResult);
				}
				if("twoPrecent".equals(key)){
					nameResult=(NameResult) nameResult.clone();
					nameResult.setName("肥胖");
					nameResult.setResult(resultMap.get(key));
					resultDouble.add(nameResult);
				}
				if("threePrecent".equals(key)){
					nameResult=(NameResult) nameResult.clone();
					nameResult.setName("极度肥胖");
					nameResult.setResult(resultMap.get(key));
					resultDouble.add(nameResult);
				}
				}
			}
		if("waistHeight".equals(everyAssessment)){
			Iterator<Map.Entry<String, Double>> it = resultMap.entrySet().iterator();  
	        while(it.hasNext()){  
	            Map.Entry<String, Double> entry=it.next();  
	            String key=entry.getKey();  
	            if("fivePrecent".equals(key)){  
	                it.remove();    
	            }
	            if("fourPrecent".equals(key)){
	            	it.remove();
	            }
	            if("threePrecent".equals(key)){
	            	it.remove();
	            }
	        } 
	        Set<String> keys=resultMap.keySet();
			for(String key:keys){
				NameResult nameResult=new NameResult();
				if("onePrecent".equals(key)){
					nameResult=(NameResult) nameResult.clone();
					nameResult.setName("正常");
					nameResult.setResult(resultMap.get(key));
					resultDouble.add(nameResult);
				}
				if("twoPrecent".equals(key)){
					nameResult=(NameResult) nameResult.clone();
					nameResult.setName("中心性肥胖");
					nameResult.setResult(resultMap.get(key));
					resultDouble.add(nameResult);
				}
				}
			}
		if("risk".equals(everyAssessment)){
	        Set<String> keys=resultMap.keySet();
			for(String key:keys){
				NameResult nameResult=new NameResult();
				if("onePrecent".equals(key)){
					nameResult=(NameResult) nameResult.clone();
					nameResult.setName("体重过低");
					nameResult.setResult(resultMap.get(key));
					resultDouble.add(nameResult);
				}
				if("twoPrecent".equals(key)){
					nameResult=(NameResult) nameResult.clone();
					nameResult.setName("正常");
					nameResult.setResult(resultMap.get(key));
					resultDouble.add(nameResult);
				}
				if("threePrecent".equals(key)){
					nameResult=(NameResult) nameResult.clone();
					nameResult.setName("增高");
					nameResult.setResult(resultMap.get(key));
					resultDouble.add(nameResult);
				}
				if("fourPrecent".equals(key)){
					nameResult=(NameResult) nameResult.clone();
					nameResult.setName("高");
					nameResult.setResult(resultMap.get(key));
					resultDouble.add(nameResult);
				}
				if("fivePrecent".equals(key)){
					nameResult=(NameResult) nameResult.clone();
					nameResult.setName("极高");
					nameResult.setResult(resultMap.get(key));
					resultDouble.add(nameResult);
				}
				}
			}
		if("pressure".equals(everyAssessment)){
	        Set<String> keys=resultMap.keySet();
			for(String key:keys){
				NameResult nameResult=new NameResult();
				if("onePrecent".equals(key)){
					nameResult=(NameResult) nameResult.clone();
					nameResult.setName("正常");
					nameResult.setResult(resultMap.get(key));
					resultDouble.add(nameResult);
				}
				if("twoPrecent".equals(key)){
					nameResult=(NameResult) nameResult.clone();
					nameResult.setName("正常高值");
					nameResult.setResult(resultMap.get(key));
					resultDouble.add(nameResult);
				}
				if("threePrecent".equals(key)){
					nameResult=(NameResult) nameResult.clone();
					nameResult.setName("一级高血压");
					nameResult.setResult(resultMap.get(key));
					resultDouble.add(nameResult);
				}
				if("fourPrecent".equals(key)){
					nameResult=(NameResult) nameResult.clone();
					nameResult.setName("二级高血压");
					nameResult.setResult(resultMap.get(key));
					resultDouble.add(nameResult);
				}
				if("fivePrecent".equals(key)){
					nameResult=(NameResult) nameResult.clone();
					nameResult.setName("三级高血压");
					nameResult.setResult(resultMap.get(key));
					resultDouble.add(nameResult);
				}
				}
			}
		if("fat".equals(everyAssessment)){
			Iterator<Map.Entry<String, Double>> it = resultMap.entrySet().iterator();  
	        while(it.hasNext()){  
	            Map.Entry<String, Double> entry=it.next();  
	            String key=entry.getKey();  
	            if("fivePrecent".equals(key)){  
	                it.remove();    
	            }
	            if("fourPrecent".equals(key)){
	            	it.remove();
	            }
	            if("threePrecent".equals(key)){
	            	it.remove();
	            }
	        } 
	        Set<String> keys=resultMap.keySet();
			for(String key:keys){
				NameResult nameResult=new NameResult();
				if("onePrecent".equals(key)){
					nameResult=(NameResult) nameResult.clone();
					nameResult.setName("正常");
					nameResult.setResult(resultMap.get(key));
					resultDouble.add(nameResult);
				}
				if("twoPrecent".equals(key)){
					nameResult=(NameResult) nameResult.clone();
					nameResult.setName("异常");
					nameResult.setResult(resultMap.get(key));
					resultDouble.add(nameResult);
				}
				}
			}
		if("metabolic".equals(everyAssessment)){
			Iterator<Map.Entry<String, Double>> it = resultMap.entrySet().iterator();  
	        while(it.hasNext()){  
	            Map.Entry<String, Double> entry=it.next();  
	            String key=entry.getKey();  
	            if("fivePrecent".equals(key)){  
	                it.remove();    
	            }
	            if("fourPrecent".equals(key)){
	            	it.remove();
	            }
	            if("threePrecent".equals(key)){
	            	it.remove();
	            }
	        } 
	        Set<String> keys=resultMap.keySet();
			for(String key:keys){
				NameResult nameResult=new NameResult();
				if("onePrecent".equals(key)){
					nameResult=(NameResult) nameResult.clone();
					nameResult.setName("正常");
					nameResult.setResult(resultMap.get(key));
					resultDouble.add(nameResult);
				}
				if("twoPrecent".equals(key)){
					nameResult=(NameResult) nameResult.clone();
					nameResult.setName("异常");
					nameResult.setResult(resultMap.get(key));
					resultDouble.add(nameResult);
				}
				}
			}
		if("atery".equals(everyAssessment)){
			Iterator<Map.Entry<String, Double>> it = resultMap.entrySet().iterator();  
	        while(it.hasNext()){  
	            Map.Entry<String, Double> entry=it.next();  
	            String key=entry.getKey();  
	            if("fivePrecent".equals(key)){  
	                it.remove();    
	            }
	            if("fourPrecent".equals(key)){
	            	it.remove();
	            }
	            if("threePrecent".equals(key)){
	            	it.remove();
	            }
	        } 
	        Set<String> keys=resultMap.keySet();
			for(String key:keys){
				NameResult nameResult=new NameResult();
				if("onePrecent".equals(key)){
					nameResult=(NameResult) nameResult.clone();
					nameResult.setName("正常");
					nameResult.setResult(resultMap.get(key));
					resultDouble.add(nameResult);
				}
				if("twoPrecent".equals(key)){
					nameResult=(NameResult) nameResult.clone();
					nameResult.setName("发生动脉硬化的危险度增加");
					nameResult.setResult(resultMap.get(key));
					resultDouble.add(nameResult);
				}
				}
			}
		 
		return resultDouble;
	}
 
}
