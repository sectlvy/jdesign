package com.sect.datax.logreport.base;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.ResultSetDynaClass;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class PersistenceHelper<T extends BaseBean> {
    protected JdbcTemplate jdbcTemplate;
    private Logger log = Logger.getLogger(PersistenceHelper.class);

    public PersistenceHelper() {
	jdbcTemplate = DatabaseManager.getMySqlJdbcTemplate();
    }

    public T saveBean(T baseBean) {
	log.debug(BeanHelper.getInsertSql(baseBean, baseBean.getTableName()));
	if (jdbcTemplate.update(BeanHelper.getInsertSql(baseBean, baseBean.getTableName())) > 0) {
	    String selectSql = BeanHelper.getSelectWhereSql(baseBean);
	    List<T> pkidList = getBeans(baseBean.getClass(), selectSql);
	    if (pkidList == null || pkidList.size() == 0) {
		log.warn(baseBean.getTableName() + "[" + selectSql + "] has no cloumn data");
		return null;
	    }
	    if (pkidList.size() != 1) {
		log.warn(baseBean.getTableName() + "[" + selectSql + "] has mutile cloumn data");
	    }
	    return pkidList.get(0);
	} else {
	    return null;
	}
    }

    public int deleteBean(String tableName, String whereSql) {
	String query = "delete from " + tableName + " " + whereSql + " ";
	return jdbcTemplate.update(query);
    }

    public void execute(String sql) {
	jdbcTemplate.execute(sql);
    }

    public List<T> getBeans(Class<? extends BaseBean> beanClass, String whereSql) {
	List<T> beanList = new ArrayList<T>();
	Connection conn = null;
	try {
	    conn = DatabaseManager.getMysqlConnection();
	    Statement stmt = conn.createStatement();
	    BaseBean baseBean = (BaseBean) beanClass.getConstructors()[0].newInstance();
	    String sql = "SELECT * FROM " + baseBean.getTableName() + " " + whereSql;
	    ResultSet rs = stmt.executeQuery(sql);
	    Iterator<?> rows = (new ResultSetDynaClass(rs)).iterator();
	    while (rows.hasNext()) {
		DynaBean row = (DynaBean) rows.next();
		@SuppressWarnings("unchecked")
		T resBean = (T) beanClass.getConstructors()[0].newInstance();
		BeanHelper.setTOBean(row, resBean);
		beanList.add(resBean);
	    }
	} catch (Exception e) {
	    log.error(e);
	} finally {
	    if (conn != null) {
		try {
		    conn.close();
		} catch (SQLException e) {
		    log.error(e);
		}
	    }
	}
	return beanList;
    }

    public void exSql(String sqlexc) {
	Connection connection = null;
	try {
	    connection = DatabaseManager.getMysqlConnection();
	    Statement stmt = connection.createStatement();
	    stmt.execute(sqlexc);
	} catch (Exception e) {
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
    }

    protected class ItemMapper implements RowMapper {
	private BaseBean bean;

	public ItemMapper(T bean) {
	    this.bean = bean;
	}

	@Override
	public Object mapRow(ResultSet resultSet, int rowNum) throws SQLException {
	    Iterator<?> rows = (new ResultSetDynaClass(resultSet)).iterator();
	    while (rows.hasNext()) {
		DynaBean dBean = (DynaBean) rows.next();
		BeanHelper.setTOBean(dBean, bean);
	    }
	    return bean;
	}

    }

    public int updateBean(T baseBean) {
	return jdbcTemplate.update(BeanHelper.getUpdateSql(baseBean, baseBean.getTableName()));
    }
}
