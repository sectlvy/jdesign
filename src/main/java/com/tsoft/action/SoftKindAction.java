package com.tsoft.action;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.ActionSupport;

import com.tsoft.dao.implAB.BaseDaoJdbcTemplate;
import com.tsoft.entity.BaseBean;
import com.tsoft.entity.softmanager.SoftKindBean;

public class SoftKindAction extends ActionSupport {
	  private Logger logger = Logger.getLogger(SoftKindAction.class);
	  public ActionForward execute(ActionMapping mapping, ActionForm form, ServletRequest request, ServletResponse response){
		  logger.info("进入 SoftKindAction 业务类");
	//		  logger.info(this.getWebApplicationContext().getBean("jdbcTemplate"));
		  SoftKindBean skb = (SoftKindBean)form;
		  return null;
	  }
	  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		  logger.info("进入 SoftKindAction HTTP 业务类");
	//		  logger.info(this.getWebApplicationContext().getBean("jdbcTemplate"));
		  SoftKindBean skb = (SoftKindBean)form;
		  this.getWebApplicationContext().getBean("jdbcTemplate");
		  BaseDaoJdbcTemplate bdt = (BaseDaoJdbcTemplate)this.getWebApplicationContext().getBean("baseDao");
		  BaseBean bb = new BaseBean();
//		  bdt.add(bb);
		  return null;
	  }
	  protected  void onInit(){
		  logger.info("进入 SoftKindAction 业务类");
	  }
	  
}
