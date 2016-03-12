/**
 * Kangle Lu
 * 2013年11月15日
 */
package com.sect.datax.logreport.logbean;

public class RtbIshowLogTmp {
    private String log_date	;//时间	String	
    private String equip_id	;//设备id	String	
    private String agency	;//代理商	String	0：云中心（默认）
    private String agency_url	;//对接RTB的域名	String	用于对接RTB的跟域名，区分不同代理商
    private String union_type	;//投放联盟	String	0:代理商 (默认)
    private String bid		;//竞价ID	String	唯一标识的竞价ID	1:tanx  2:google
    private String rtb_id	;//rtb cookieid	String	rtb对用户的唯一标识
    private String agency_cookie;//	代理商 cookieid	String	代理商的cookieid
    private String User_id	;//用户ID	String	来自于运营商数据的UID
    private String cash_min	;//cash_min	int(10)	最低竞标价格（置0）
    private String cash_res	;//cash_res	int(10)	出价金额（置0）
    private String cash_value	;//cash_value	String	成交金额
    private String adp_id	;//广告位id	String	
    private String  ad_id	;//广告id	String	
    private String goods_id	;//物料id	String	
    private String ope_id	;//运营商id	String	
    private String opereg_id	;//区域id	String	
    private String execut_id	;//执行单id	String	
    private String ip		;//ip String	
    private String CTR_tag	;//Ctr标签	String	Ctr模型使用的标签
    /**
     * @return the log_date
     */
    public String getLog_date() {
        return log_date;
    }
    /**
     * @param log_date the log_date to set
     */
    public void setLog_date(String log_date) {
        this.log_date = log_date;
    }
    /**
     * @return the equip_id
     */
    public String getEquip_id() {
        return equip_id;
    }
    /**
     * @param equip_id the equip_id to set
     */
    public void setEquip_id(String equip_id) {
        this.equip_id = equip_id;
    }
    /**
     * @return the agency
     */
    public String getAgency() {
        return agency;
    }
    /**
     * @param agency the agency to set
     */
    public void setAgency(String agency) {
        this.agency = agency;
    }
    /**
     * @return the agency_url
     */
    public String getAgency_url() {
        return agency_url;
    }
    /**
     * @param agency_url the agency_url to set
     */
    public void setAgency_url(String agency_url) {
        this.agency_url = agency_url;
    }
    /**
     * @return the union_type
     */
    public String getUnion_type() {
        return union_type;
    }
    /**
     * @param union_type the union_type to set
     */
    public void setUnion_type(String union_type) {
        this.union_type = union_type;
    }
    /**
     * @return the bid
     */
    public String getBid() {
        return bid;
    }
    /**
     * @param bid the bid to set
     */
    public void setBid(String bid) {
        this.bid = bid;
    }
    /**
     * @return the rtb_id
     */
    public String getRtb_id() {
        return rtb_id;
    }
    /**
     * @param rtb_id the rtb_id to set
     */
    public void setRtb_id(String rtb_id) {
        this.rtb_id = rtb_id;
    }
    /**
     * @return the agency_cookie
     */
    public String getAgency_cookie() {
        return agency_cookie;
    }
    /**
     * @param agency_cookie the agency_cookie to set
     */
    public void setAgency_cookie(String agency_cookie) {
        this.agency_cookie = agency_cookie;
    }
    /**
     * @return the user_id
     */
    public String getUser_id() {
        return User_id;
    }
    /**
     * @param user_id the user_id to set
     */
    public void setUser_id(String user_id) {
        User_id = user_id;
    }
    /**
     * @return the cash_min
     */
    public String getCash_min() {
        return cash_min;
    }
    /**
     * @param cash_min the cash_min to set
     */
    public void setCash_min(String cash_min) {
        this.cash_min = cash_min;
    }
    /**
     * @return the cash_res
     */
    public String getCash_res() {
        return cash_res;
    }
    /**
     * @param cash_res the cash_res to set
     */
    public void setCash_res(String cash_res) {
        this.cash_res = cash_res;
    }
    /**
     * @return the cash_value
     */
    public String getCash_value() {
        return cash_value;
    }
    /**
     * @param cash_value the cash_value to set
     */
    public void setCash_value(String cash_value) {
        this.cash_value = cash_value;
    }
    /**
     * @return the adp_id
     */
    public String getAdp_id() {
        return adp_id;
    }
    /**
     * @param adp_id the adp_id to set
     */
    public void setAdp_id(String adp_id) {
        this.adp_id = adp_id;
    }
    /**
     * @return the ad_id
     */
    public String getAd_id() {
        return ad_id;
    }
    /**
     * @param ad_id the ad_id to set
     */
    public void setAd_id(String ad_id) {
        this.ad_id = ad_id;
    }
    /**
     * @return the goods_id
     */
    public String getGoods_id() {
        return goods_id;
    }
    /**
     * @param goods_id the goods_id to set
     */
    public void setGoods_id(String goods_id) {
        this.goods_id = goods_id;
    }
    /**
     * @return the ope_id
     */
    public String getOpe_id() {
        return ope_id;
    }
    /**
     * @param ope_id the ope_id to set
     */
    public void setOpe_id(String ope_id) {
        this.ope_id = ope_id;
    }
    /**
     * @return the opereg_id
     */
    public String getOpereg_id() {
        return opereg_id;
    }
    /**
     * @param opereg_id the opereg_id to set
     */
    public void setOpereg_id(String opereg_id) {
        this.opereg_id = opereg_id;
    }
    /**
     * @return the execut_id
     */
    public String getExecut_id() {
        return execut_id;
    }
    /**
     * @param execut_id the execut_id to set
     */
    public void setExecut_id(String execut_id) {
        this.execut_id = execut_id;
    }
    /**
     * @return the ip
     */
    public String getIp() {
        return ip;
    }
    /**
     * @param ip the ip to set
     */
    public void setIp(String ip) {
        this.ip = ip;
    }
    /**
     * @return the cTR_tag
     */
    public String getCTR_tag() {
        return CTR_tag;
    }
    /**
     * @param cTR_tag the cTR_tag to set
     */
    public void setCTR_tag(String cTR_tag) {
        CTR_tag = cTR_tag;
    }
}
