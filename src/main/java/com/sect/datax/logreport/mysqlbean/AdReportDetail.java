package com.sect.datax.logreport.mysqlbean;

import com.sect.datax.logreport.base.BaseBean;

public class AdReportDetail extends BaseBean {
    private long pkid;
    private String ad_cid;
    private long ad_exchange_id;
    private long request_num;
    private long response_num;
    private long show_num;
    private long click_num;
    private double total_money;
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
     * @return the ad_cid
     */
    public String getAd_cid() {
        return ad_cid;
    }


    /**
     * @param ad_cid the ad_cid to set
     */
    public void setAd_cid(String ad_cid) {
        this.ad_cid = ad_cid;
    }


    /**
     * @return the ad_exchange_id
     */
    public long getAd_exchange_id() {
        return ad_exchange_id;
    }


    /**
     * @param ad_exchange_id the ad_exchange_id to set
     */
    public void setAd_exchange_id(long ad_exchange_id) {
        this.ad_exchange_id = ad_exchange_id;
    }


    /**
     * @return the request_num
     */
    public long getRequest_num() {
        return request_num;
    }


    /**
     * @param request_num the request_num to set
     */
    public void setRequest_num(long request_num) {
        this.request_num = request_num;
    }


    /**
     * @return the response_num
     */
    public long getResponse_num() {
        return response_num;
    }


    /**
     * @param response_num the response_num to set
     */
    public void setResponse_num(long response_num) {
        this.response_num = response_num;
    }


    /**
     * @return the show_num
     */
    public long getShow_num() {
        return show_num;
    }


    /**
     * @param show_num the show_num to set
     */
    public void setShow_num(long show_num) {
        this.show_num = show_num;
    }


    /**
     * @return the click_num
     */
    public long getClick_num() {
        return click_num;
    }


    /**
     * @param click_num the click_num to set
     */
    public void setClick_num(long click_num) {
        this.click_num = click_num;
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
	/**create this table**/
	return "ad_report_detail_yyyymmdd";
    }

}
