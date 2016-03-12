package com.tsoft.dao.impl;

import com.tsoft.dao.SoftDao;
import com.tsoft.dao.implAB.BaseDaoJdbcTemplate;
import com.tsoft.entity.softmanager.SoftBean;

public class SoftDaoImpl extends BaseDaoJdbcTemplate implements SoftDao {
	private static final String insertSoft = "INSERT INTO xx () values(?)";
	public int addSoft(SoftBean softBean) {
		jdbcTemplate.execute(insertSoft);
		return 0;
	}

}
