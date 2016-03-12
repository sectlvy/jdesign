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
import com.tsoft.entity.softmanager.SoftBean;
import com.tsoft.service.SoftService;

public class SoftAction extends ActionSupport {
	  private Logger logger = Logger.getLogger(SoftAction.class);
	  public ActionForward execute(ActionMapping mapping, ActionForm form, ServletRequest request, ServletResponse response){
		  logger.info("进入 SoftAction 业务类");
	//		  logger.info(this.getWebApplicationContext().getBean("jdbcTemplate"));
		  SoftBean sb = (SoftBean)form;
		  return null;
	  }
	  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		  logger.info("进入 SoftAction HTTP 业务类");
		  SoftBean softBean = (SoftBean)form;
		  
		  
		  SoftService softService = (SoftService)this.getWebApplicationContext().getBean("softService");
		  int insertFlag = softService.addSoft(softBean);
		  return null;
	  }
	  protected  void onInit(){
		  logger.info("进入 SoftAction 业务类");
	  }
	  
}
