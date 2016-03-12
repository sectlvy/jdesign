/**
 * Kangle Lu
 * 2013��11��15��
 */
package com.sect.datax.logreport.mysqlbean;

import com.sect.datax.logreport.base.BaseBean;

public class AdReportRealtime extends BaseBean{
    private long pkid;
    private String time;
    private long request_num;
    private long response_num;
    private long show_num;
    private long click_num;
    private double total_money;
    private int avg_delay_time;
    private int max_delay_time;
    
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
     * @return the time
     */
    public String getTime() {
        return time;
    }


    /**
     * @param time the time to set
     */
    public void setTime(String time) {
        this.time = time;
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
     * @return the avg_delay_time
     */
    public int getAvg_delay_time() {
        return avg_delay_time;
    }


    /**
     * @param avg_delay_time the avg_delay_time to set
     */
    public void setAvg_delay_time(int avg_delay_time) {
        this.avg_delay_time = avg_delay_time;
    }


    /**
     * @return the max_delay_time
     */
    public int getMax_delay_time() {
        return max_delay_time;
    }


    /**
     * @param max_delay_time the max_delay_time to set
     */
    public void setMax_delay_time(int max_delay_time) {
        this.max_delay_time = max_delay_time;
    }


    @Override
    public String getTableName() {
	return "ad_report_realtime";
    }
    
}
