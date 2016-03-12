/**
 * Kangle Lu
 * 2013��11��15��
 */
package com.sect.datax.logreport.mysqlbean;

import com.sect.datax.logreport.base.BaseBean;

public class AdScheduleReport extends BaseBean {
    private long pkid;//	����id	int(11)
    private String date	;//����	varchar(64)
    private long ad_schedule_id	;//���λid	int(11)
    private long request_num	;//�����������	bigint(12)
    private long response_num	;//��Ӧ����	bigint(12)
    private long show_num	;//չʾ����	bigint(12)
    private long click_num	;//�������	bigint(12)
    private double total_money	;//���۽��	double(10,2)
    private double count_money	;//�ɽ����	double(10,2)
    
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
     * @return the date
     */
    public String getDate() {
        return date;
    }


    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }


    /**
     * @return the ad_schedule_id
     */
    public long getAd_schedule_id() {
        return ad_schedule_id;
    }


    /**
     * @param ad_schedule_id the ad_schedule_id to set
     */
    public void setAd_schedule_id(long ad_schedule_id) {
        this.ad_schedule_id = ad_schedule_id;
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
	return "ad_schedule_report";
    }

}
