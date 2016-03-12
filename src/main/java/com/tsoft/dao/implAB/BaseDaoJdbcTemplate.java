package com.tsoft.dao.implAB;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import com.tsoft.dao.BaseDao;

public abstract class BaseDaoJdbcTemplate implements BaseDao {
	
	protected Logger logger = Logger.getLogger(BaseDaoJdbcTemplate.class);
	
	protected JdbcTemplate jdbcTemplate;
	
	public BaseDaoJdbcTemplate(){}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
}
