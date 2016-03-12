/**
 * Kangle Lu
 * 2013��11��15��
 */
package com.sect.datax.logreport.mysqlbean;

import com.sect.datax.logreport.base.BaseBean;

public class AdReportOverview extends BaseBean {
    private long pkid;
    private String ad_time;
    private String top_tag;
    private String top_area;
    private String top_ad;
    private double total_money;
    private double earning;
    private double count_money;

    /**
     * @return the pkid
     */
    public long getPkid() {
        return pkid;
    }


    /**
     * @param pkid the pkid to set
     */
    public void setPkid(long pkid) {
        this.pkid = pkid;
    }


    /**
     * @return the ad_time
     */
    public String getAd_time() {
        return ad_time;
    }


    /**
     * @param ad_time the ad_time to set
     */
    public void setAd_time(String ad_time) {
        this.ad_time = ad_time;
    }


    /**
     * @return the top_tag
     */
    public String getTop_tag() {
        return top_tag;
    }


    /**
     * @param top_tag the top_tag to set
     */
    public void setTop_tag(String top_tag) {
        this.top_tag = top_tag;
    }


    /**
     * @return the top_area
     */
    public String getTop_area() {
        return top_area;
    }


    /**
     * @param top_area the top_area to set
     */
    public void setTop_area(String top_area) {
        this.top_area = top_area;
    }


    /**
     * @return the top_ad
     */
    public String getTop_ad() {
        return top_ad;
    }


    /**
     * @param top_ad the top_ad to set
     */
    public void setTop_ad(String top_ad) {
        this.top_ad = top_ad;
    }


    /**
     * @return the total_money
     */
    public double getTotal_money() {
        return total_money;
    }


    /**
     * @param total_money the total_money to set
     */
    public void setTotal_money(double total_money) {
        this.total_money = total_money;
    }


    /**
     * @return the earning
     */
    public double getEarning() {
        return earning;
    }


    /**
     * @param earning the earning to set
     */
    public void setEarning(double earning) {
        this.earning = earning;
    }


    /**
     * @return the count_money
     */
    public double getCount_money() {
        return count_money;
    }


    /**
     * @param count_money the count_money to set
     */
    public void setCount_money(double count_money) {
        this.count_money = count_money;
    }


    @Override
    public String getTableName() {
	return "ad_report_overview";
    }

}
