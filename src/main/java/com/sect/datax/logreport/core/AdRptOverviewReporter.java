/**
 * Kangle Lu
 * 2013骞�1鏈�6鏃�
 */
package com.sect.datax.logreport.core;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import com.sect.datax.logreport.base.ConfigLoader;
import com.sect.datax.logreport.base.ImpalaHelper;
import com.sect.datax.logreport.base.PersistenceHelper;
import com.sect.datax.logreport.base.RSystemInit;
import com.sect.datax.logreport.mysqlbean.AdReportOverview;

public class AdRptOverviewReporter {
	private static Logger log = Logger.getLogger(AdRptOverviewReporter.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RSystemInit.init(args);

		SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMdd");
		String dateTimeStr = sdf.format(new Date());
		AdRptOverviewReporter adRptOverviewLogWriter = new AdRptOverviewReporter();
		log.info("start to count the data from impala");
		AdReportOverview adReportOverview = adRptOverviewLogWriter.getDataFromImpala(dateTimeStr);
		log.info("start to save impala result to mysql");
		adRptOverviewLogWriter.saveRes(adReportOverview);
	}

	public void saveRes(AdReportOverview adReportOverview) {
		PersistenceHelper<AdReportOverview> persistenceHelper = new PersistenceHelper<AdReportOverview>();
		persistenceHelper.saveBean(adReportOverview);
	}

	/**
	 * p_date='2013111417' impala partition
	 * 
	 * @param dateTimeStr
	 * @return
	 */
	public AdReportOverview getDataFromImpala(String dateTimeStr) {
		AdReportOverview adReportOverview = new AdReportOverview();
		/***
		 * pkid 主键 ad_time 2013111622 top_tag select count(ctrtag) as tag_num
		 * from rtb_ische_log group by ctrtag where log_date='2013111417' ;
		 * [a:100,b:152.....] top_area select count(area) as tag_num from
		 * rtb_ische_log group by area where log_date='2013111417';
		 * [a:100,b:152.....] area top_ad select count(ad_id) as tag_num from
		 * rtb_ische_log group by ad_id where log_date='2013111417'; ad_id
		 * total_money select sum(cash_res) from rtb_ische_log where
		 * log_date='2013111417'; earning ???? count_money select
		 * sum(cash_value) from rtb_ische_log where log_date='2013111417';
		 */
		ImpalaHelper impalaHelper = new ImpalaHelper();
		String pdatestr = "";
		for (int i = 0; i < 23; i++) {
			if (i < 10) {
				pdatestr = pdatestr + " p_date=\"" + dateTimeStr + "0" + i + "\" or ";
				impalaHelper.addParationIfExist("rtb_ische_log", dateTimeStr + "0" + i);
				impalaHelper.addParationIfExist("rtb_ishow_log_tmp", dateTimeStr + "0" + i);
			} else {
				pdatestr = pdatestr + " p_date=\"" + dateTimeStr + "" + i + "\" or ";
				impalaHelper.addParationIfExist("rtb_ische_log", dateTimeStr + "" + i);
				impalaHelper.addParationIfExist("rtb_ishow_log_tmp", dateTimeStr + "" + i);
			}
		}
		pdatestr = pdatestr + " p_date=\"" + dateTimeStr + "23\" ";
		int limit = 200;
		if(ConfigLoader.getProperty("limit")!=null && ConfigLoader.getProperty("limit").length()>0){
			limit =  Integer.valueOf(ConfigLoader.getProperty("limit"));
		}
		String top_tag_Sql = "select ctrtag,count(ctrtag) as tag_num from rtb_ische_log where " + pdatestr + " group by ctrtag limit "+limit+"";
		String top_area_SQL = "select area,count(area) as tag_num from rtb_ische_log where " + pdatestr + "  group by area limit "+limit+"";
		String top_ad_SQL = "select ad_id,count(ad_id) as tag_num from rtb_ische_log where " + pdatestr + "  group by ad_id limit "+limit+"";
		String total_money_Sql = "select sum(case_res) from  rtb_ische_log where " + pdatestr + "";
		String count_money_SQL = "select sum(case_value) from  rtb_ische_log  where " + pdatestr + "";
		log.info("top_tag_Sql:" + top_tag_Sql);
		log.info("top_area_SQL:" + top_area_SQL);
		log.info("top_ad_SQL:" + top_ad_SQL);
		log.info("total_money_Sql:" + total_money_Sql);
		log.info("count_money_SQL:" + count_money_SQL);

		log.info("start to execute :[" + top_tag_Sql + "]");
		adReportOverview.setTop_tag(impalaHelper.getResultAsKeyVal(top_tag_Sql));
		log.info("start to execute :[" + top_area_SQL + "]");
		adReportOverview.setTop_area(impalaHelper.getResultAsKeyVal(top_area_SQL));
		log.info("start to execute :[" + top_ad_SQL + "]");
		adReportOverview.setTop_ad(impalaHelper.getResultAsKeyVal(top_ad_SQL));
		log.info("start to execute :[" + total_money_Sql + "]");
		adReportOverview.setTotal_money(Double.valueOf(impalaHelper.getResult(total_money_Sql, 1).get(0)));
		log.info("start to execute :[" + count_money_SQL + "]");
		adReportOverview.setCount_money(Double.valueOf(impalaHelper.getResult(count_money_SQL, 1).get(0)));
		adReportOverview.setAd_time(dateTimeStr);
		return adReportOverview;
	}

}
