/**
 * Kangle Lu
 * 2013��11��22��
 */
package com.sect.datax.logreport.core;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.sect.datax.logreport.base.DatabaseManager;
import com.sect.datax.logreport.base.ImpalaHelper;
import com.sect.datax.logreport.base.PersistenceHelper;
import com.sect.datax.logreport.base.RSystemInit;
import com.sect.datax.logreport.mysqlbean.AdReportDetail;

public class AdReportDetailReporter {
    private PersistenceHelper<AdReportDetail> persistenceHelper;
    private static Logger log = Logger.getLogger(AdReportDetailReporter.class);

    public AdReportDetailReporter() {
	persistenceHelper = new PersistenceHelper<AdReportDetail>();
    }

    public static void main(String[] args) {
	RSystemInit.init(args);

	SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMdd");
	String dateTimeStr = sdf.format(new Date());

	AdReportDetailReporter adReportDetailReporter = new AdReportDetailReporter();

	List<AdReportDetail> adreports = adReportDetailReporter.getDataFromImpala(dateTimeStr);
	for (AdReportDetail adReportDetail : adreports) {
	    adReportDetailReporter.saveRes(adReportDetail);
	}
	if (adReportDetailReporter.createTable(dateTimeStr)) {
	    // List<AdReportDetail> adreports =
	    // adReportDetailReporter.getDataFromImpala(dateTimeStr);
	    // for(AdReportDetail adReportDetail : adreports){
	    // adReportDetailReporter.saveRes(adReportDetail);
	    // }
	}

    }

    /**
     * @param adReportDetail
     */
    private void saveRes(AdReportDetail adReportDetail) {
	persistenceHelper.saveBean(adReportDetail);
    }

    /**
     * @param dateTimeStr
     * @return
     */
    private List<AdReportDetail> getDataFromImpala(String dateTimeStr) {

	ImpalaHelper impalaHelper = new ImpalaHelper();
	impalaHelper.addParationIfExist("rtb_iclick_log_tmp", dateTimeStr);
	impalaHelper.addParationIfExist("rtb_ishow_log_tmp", dateTimeStr);

	StringBuffer querySql = new StringBuffer();
	querySql.append(" select a.ad_cid,a.show_number,b.click_number,b.total_money,b.count_money from ");
	querySql.append(" (select ad_id as ad_cid,count(ad_id) as show_number from rtb_ishow_log_tmp where p_date='" + dateTimeStr + "' group by (ad_id)) as a,");
	querySql.append(" (select ad_id as ad_cid,count(ad_id) as click_number,sum(cash_res) as total_money,sum(cash_value) as count_money from  rtb_iclick_log_tmp where p_date='"
		+ dateTimeStr + "' group by (ad_id)) AS b");
	querySql.append(" where a.ad_cid=b.ad_cid;");
	Connection connection = null;
	List<AdReportDetail> resList = new ArrayList<AdReportDetail>();
	try {
	    connection = DatabaseManager.getImpalaConnection();
	    Statement stmt = connection.createStatement();
//	    ResultSet rs = stmt.executeQuery(querySql.toString());
	    StringBuffer tsql = new StringBuffer();
//	    tsql.append(" CREATE VIEW rtb_ishow_log_tmp_view (ad_cid,show_number)");
//	    tsql.append(" AS select ad_id as ad_cid,count(ad_id) as show_number from rtb_ishow_log_tmp where p_date='20131122' group by (ad_id);");
//
//	    tsql.append(" create view rtb_iclick_log_tmp_view (ad_cid,click_number,total_money,count_money)");
//	    tsql.append(" as select ad_id as ad_cid,count(ad_id) as click_number,sum(cash_res) as total_money,sum(cash_value) as count_money from  rtb_iclick_log_tmp where p_date='20131122' group by (ad_id);");

//	    tsql.append(" insert into detail_rtb_ishow partition(p_date='20131122') select ad_id as ad_cid,count(ad_id) as show_number from rtb_ishow_log_tmp where p_date='20131122' group by (ad_id); ");
//	    tsql.append(" insert into detail_rtb_iclick partition(p_date='20131122') select ad_id as ad_cid,count(ad_id) as click_number,sum(cash_res) as total_money,sum(cash_value) as count_money from  rtb_iclick_log_tmp where p_date='20131122' group by (ad_id);");
	    tsql.append(" select detail_rtb_ishow.* from detail_rtb_ishow join detail_rtb_iclick on detail_rtb_iclick.ad_cid=detail_rtb_ishow.ad_cid;");
//	    tsql.append(" select a.ad_cid,a.show_number,b.click_number,b.total_money,b.count_money from ");
//	    tsql.append(" rtb_ishow_log_tmp_view as a,rtb_iclick_log_tmp_view as b");
//	    tsql.append(" where a.ad_cid=b.ad_cid;");

	    String testSql = "select * from "
		    + " (select ad_id as ad_cid,count(ad_id) as show_number from rtb_ishow_log_tmp where p_date='20131122' group by (ad_id) ) as a, "
		    + " (select ad_id as ad_cid,count(ad_id) as click_number,sum(cash_res) as total_money,sum(cash_value) as count_money from  rtb_iclick_log_tmp where p_date='20131122' group by (ad_id)) AS b "
		    + " on a.ad_cid=b.ad_cid;";
	    
	    ResultSet rs = stmt.executeQuery(tsql.toString());
	    while (rs.next()) {
		AdReportDetail adReportDetail = new AdReportDetail();
		adReportDetail.setAd_cid(rs.getString(1));
		adReportDetail.setShow_num(rs.getLong(2));
		adReportDetail.setClick_num(rs.getLong(3));
		adReportDetail.setTotal_money(rs.getDouble(4));
		adReportDetail.setCount_money(rs.getDouble(5));
		resList.add(adReportDetail);
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    log.error(e);
	} finally {
	    if (connection != null) {
		try {
		    connection.close();
		} catch (SQLException e) {
		    log.error(e);
		}
	    }
	}
	return resList;
    }

    /**
     * 
     */
    private boolean createTable(String dateTimeStr) {
	StringBuffer createSql = new StringBuffer();
	createSql.append("CREATE TABLE `ad_report_detail_" + dateTimeStr + "` (");
	createSql.append("`pkid` int(12) NOT NULL AUTO_INCREMENT,");
	createSql.append("`ad_cid` varchar(64) DEFAULT NULL,");
	createSql.append("`ad_exchange_id` int(12) DEFAULT NULL,");
	createSql.append("`request_num` bigint(12) DEFAULT NULL,");
	createSql.append("`response_num` bigint(12) DEFAULT NULL,");
	createSql.append("`show_num` bigint(12) DEFAULT NULL,");
	createSql.append("`click_num` bigint(12) DEFAULT NULL,");
	createSql.append("`total_money` double(10,2) DEFAULT NULL,");
	createSql.append("`count_money` double(10,2) DEFAULT NULL,");
	createSql.append("PRIMARY KEY (`pkid`))");
	boolean createFlag = false;
	try {
	    persistenceHelper.execute(createSql.toString());
	    createFlag = true;
	} catch (Exception e) {
	    log.error("when create table [ad_report_detail_" + dateTimeStr + "]" + e);
	}
	return createFlag;
    }
}
