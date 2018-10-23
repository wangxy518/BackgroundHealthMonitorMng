package HealthMonitorMng.service.impl.background;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import HealthMonitorMng.hbm.base.BloodG;
import HealthMonitorMng.hbm.base.BloodPressure;
import HealthMonitorMng.hbm.base.HighWeight;
import HealthMonitorMng.hbm.base.Waistline;
import HealthMonitorMng.hbm.base.background.NameResult;
import HealthMonitorMng.service.background.DetectionAnalysisServiceI;
import HealthMonitorMng.service.impl.BaseServiceImpl;
@Transactional
@Service("detectionAnalysisService")
public class DetectionAnalysisServiceImpl extends BaseServiceImpl implements DetectionAnalysisServiceI{

	@Override
	public List<NameResult> getWaistlineScope(String data) throws Exception {
		List<NameResult> nameList=new ArrayList<NameResult>();
		NameResult nameResult=new NameResult();
		if("waistline".equals(data)){
		String hql="from Waistline";
		int letterNumber = 0,number = 0,moreNumber = 0;
		Query query=super.getBaseDao().createQuery(hql);
		List<Waistline> waistlines=query.list();
		int sum=waistlines.size();
		for(int i=0;i<waistlines.size();i++){
			Double waistline=waistlines.get(i).getWaistline();
			if(waistline==null){
				sum--;
			}else{
			if(waistline<80.0){
				letterNumber++;
			}else if(waistline>90.0){
				moreNumber++;
			}else{
				number++;
			}
		}
		}
		Double onePrecent= ((double)letterNumber/sum)*100;
		onePrecent=getPrecent(onePrecent);
		nameResult.setResult(onePrecent);
		nameResult.setScope("小于80厘米");
		nameList.add(nameResult);
		Double twoPrecent= ((double)number/sum)*100;
		twoPrecent=getPrecent(twoPrecent);
		nameResult=(NameResult) nameResult.clone();
		nameResult.setResult(twoPrecent);
		nameResult.setScope("80-90之间");
		nameList.add(nameResult);
		Double threePrecent= ((double)moreNumber/sum)*100;
		threePrecent=getPrecent(threePrecent);
		nameResult=(NameResult) nameResult.clone();
		nameResult.setResult(threePrecent);
		nameResult.setScope("90厘米以上");
		nameList.add(nameResult);
		}
		if("height".equals(data)){
			String hql="from HighWeight";
			int letterNumber = 0,fourNumber = 0,moreNumber = 0,fiveNumber=0,sixNumber=0,sevenNumber=0;
			Query query=super.getBaseDao().createQuery(hql);
			List<HighWeight> heightWeight=query.list();
			int sum=heightWeight.size();
			for(int i=0;i<heightWeight.size();i++){
				Double height=heightWeight.get(i).getHeight();
				if(height==null){
					sum--;
				}else{
				if(height>190.0){
					moreNumber++;
				}else if(180<height&&height<190){
					sevenNumber++;
				}else if(height>170&&height<180){
					sixNumber++;
				}else if(height>160&&height<170){
					fiveNumber++;
				}else if(height>150&&height<160){
					fourNumber++;
				}else{
					letterNumber++;
				}
				}
			}
			Double onePrecent= ((double)letterNumber/sum)*100;
			onePrecent=getPrecent(onePrecent);
			nameResult.setResult(onePrecent);
			nameResult.setScope("150厘米以下");
			nameList.add(nameResult);
			Double twoPrecent= ((double)fourNumber/sum)*100;
			twoPrecent=getPrecent(twoPrecent);
			nameResult=(NameResult) nameResult.clone();
			nameResult.setResult(twoPrecent);
			nameResult.setScope("150-159厘米");
			nameList.add(nameResult);
			Double fourPrecent= ((double)fiveNumber/sum)*100;
			fourPrecent=getPrecent(fourPrecent);
			nameResult=(NameResult) nameResult.clone();
			nameResult.setResult(fourPrecent);
			nameResult.setScope("160-169厘米");
			nameList.add(nameResult);
			Double fivePrecent= ((double)sixNumber/sum)*100;
			fivePrecent=getPrecent(fivePrecent);
			nameResult=(NameResult) nameResult.clone();
			nameResult.setResult(fivePrecent);
			nameResult.setScope("170-179厘米");
			nameList.add(nameResult);
			Double sixPrecent= ((double)sevenNumber/sum)*100;
			sixPrecent=getPrecent(sixPrecent);
			nameResult=(NameResult) nameResult.clone();
			nameResult.setResult(sixPrecent);
			nameResult.setScope("180-189厘米");
			nameList.add(nameResult);
			Double threePrecent= ((double)moreNumber/sum)*100;
			threePrecent=getPrecent(threePrecent);
			nameResult=(NameResult) nameResult.clone();
			nameResult.setResult(threePrecent);
			nameResult.setScope("190厘米以上");
			nameList.add(nameResult);
		}if("weight".equals(data)){
				String hql="from HighWeight";
				int letterNumber = 0,fourNumber = 0,moreNumber = 0,fiveNumber=0,sixNumber=0,sevenNumber=0;
				Query query=super.getBaseDao().createQuery(hql);
				List<HighWeight> heightWeight=query.list();
				int sum=heightWeight.size();
				for(int i=0;i<heightWeight.size();i++){
					Double weight=heightWeight.get(i).getWeight();
					if(weight==null){
						sum--;
					}else{
					if(weight>80.0){
						moreNumber++;
					}else if(70<weight&&weight<80){
						sevenNumber++;
					}else if(weight>60&&weight<70){
						sixNumber++;
					}else if(weight>50&&weight<60){
						fiveNumber++;
					}else if(weight>40&&weight<50){
						fourNumber++;
					}else{
						letterNumber++;
					}
					}
				}
				Double onePrecent= ((double)letterNumber/sum)*100;
				onePrecent=getPrecent(onePrecent);
				nameResult.setResult(onePrecent);
				nameResult.setScope("40kg以下");
				nameList.add(nameResult);
				Double twoPrecent= ((double)fourNumber/sum)*100;
				twoPrecent=getPrecent(twoPrecent);
				nameResult=(NameResult) nameResult.clone();
				nameResult.setResult(twoPrecent);
				nameResult.setScope("40-49kg");
				nameList.add(nameResult);
				Double fourPrecent= ((double)fiveNumber/sum)*100;
				fourPrecent=getPrecent(fourPrecent);
				nameResult=(NameResult) nameResult.clone();
				nameResult.setResult(fourPrecent);
				nameResult.setScope("50-59kg");
				nameList.add(nameResult);
				Double fivePrecent= ((double)sixNumber/sum)*100;
				fivePrecent=getPrecent(fivePrecent);
				nameResult=(NameResult) nameResult.clone();
				nameResult.setResult(fivePrecent);
				nameResult.setScope("60-69kg");
				nameList.add(nameResult);
				Double sixPrecent= ((double)sevenNumber/sum)*100;
				sixPrecent=getPrecent(sixPrecent);
				nameResult=(NameResult) nameResult.clone();
				nameResult.setResult(sixPrecent);
				nameResult.setScope("70-79kg");
				nameList.add(nameResult);
				Double threePrecent= ((double)moreNumber/sum)*100;
				threePrecent=getPrecent(threePrecent);
				nameResult=(NameResult) nameResult.clone();
				nameResult.setResult(threePrecent);
				nameResult.setScope("80kg以上");
				nameList.add(nameResult);
			}
		if("pressure".equals(data)){
			String hql="from BloodPressure";
			int letterNumber = 0,fourNumber = 0,moreNumber = 0,fiveNumber=0,sixNumber=0,sevenNumber=0;
			Query query=super.getBaseDao().createQuery(hql);
			List<BloodPressure> pressures=query.list();
			int sum=pressures.size();
			for(int i=0;i<pressures.size();i++){
				Double dbp=pressures.get(i).getDBP();
				Double sbp=pressures.get(i).getSBP();
				if(dbp==null||sbp==null){
					sum--;
				}else{
				if(sbp>180&&dbp>=110){
					moreNumber++;
				}else if((sbp>160&&sbp<180)&&(dbp>100&&dbp<110)){
					sevenNumber++;
				}else if((sbp>140&&sbp<160)&&(dbp>90&&dbp<100)){
					sixNumber++;
				}else if((sbp>120&&sbp<140)&&(dbp>80&&dbp<90)){
					fiveNumber++;
				}else{
					letterNumber++;
				}
				}
			}
			Double onePrecent= ((double)letterNumber/sum)*100;
			onePrecent=getPrecent(onePrecent);
			nameResult.setResult(onePrecent);
			nameResult.setScope("收缩压小于120且舒张压小于80");
			nameList.add(nameResult);
			Double fourPrecent= ((double)fiveNumber/sum)*100;
			fourPrecent=getPrecent(fourPrecent);
			nameResult=(NameResult) nameResult.clone();
			nameResult.setResult(fourPrecent);
			nameResult.setScope("收缩压在120-139且舒张压在80-89之间");
			nameList.add(nameResult);
			Double fivePrecent= ((double)sixNumber/sum)*100;
			fivePrecent=getPrecent(fivePrecent);
			nameResult=(NameResult) nameResult.clone();
			nameResult.setResult(fivePrecent);
			nameResult.setScope("收缩压在140-159且舒张压在90-99之间");
			nameList.add(nameResult);
			Double sixPrecent= ((double)sevenNumber/sum)*100;
			sixPrecent=getPrecent(sixPrecent);
			nameResult=(NameResult) nameResult.clone();
			nameResult.setResult(sixPrecent);
			nameResult.setScope("收缩压在160-179且舒张压在100-109之间");
			nameList.add(nameResult);
			Double threePrecent= ((double)moreNumber/sum)*100;
			threePrecent=getPrecent(threePrecent);
			nameResult=(NameResult) nameResult.clone();
			nameResult.setResult(threePrecent);
			nameResult.setScope("收缩压大于180且舒张压大于等于110");
			nameList.add(nameResult);
		}if("sugar".equals(data)){
			String hql="from BloodG";
			int letterNumber = 0,number = 0,moreNumber = 0;
			Query query=super.getBaseDao().createQuery(hql);
			List<BloodG> bloodSugars=query.list();
			int sum=bloodSugars.size();
			for(int i=0;i<bloodSugars.size();i++){
				Double bgfasting=bloodSugars.get(i).getBGFasting();
				if(bgfasting==null){
					sum--;
				}else{
				if(bgfasting>=7.0){
					moreNumber++;
				}else if(bgfasting>=6.1&&bgfasting<7.0){
					number++;
				}else{
					letterNumber++;
				}
				}
			}
			Double onePrecent= ((double)letterNumber/sum)*100;
			onePrecent=getPrecent(onePrecent);
			nameResult.setResult(onePrecent);
			nameResult.setScope("小于6.1mmol/L");
			nameList.add(nameResult);
			Double twoPrecent= ((double)number/sum)*100;
			twoPrecent=getPrecent(twoPrecent);
			nameResult=(NameResult) nameResult.clone();
			nameResult.setResult(twoPrecent);
			nameResult.setScope("6.1-7.0mmol/L");
			nameList.add(nameResult);
			Double threePrecent= ((double)moreNumber/sum)*100;
			threePrecent=getPrecent(threePrecent);
			nameResult=(NameResult) nameResult.clone();
			nameResult.setResult(threePrecent);
			nameResult.setScope("7mmol/L以上");
			nameList.add(nameResult);
			}
		return nameList;
	}
	public Double getPrecent(Double precent){
		DecimalFormat df = new DecimalFormat("0.#");
		String tmp = df.format(precent);
		return Double.parseDouble(tmp);
	}

}
