/**
 * Kangle Lu
 * 2013骞�1鏈�6鏃�
 */
package com.sect.datax.logreport.base;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class ImpalaHelper {
	private Logger log = Logger.getLogger(ImpalaHelper.class);

	public boolean addParationIfExist(String tablename, String parationStr) {
		String esql = "select " + parationStr + " from " + tablename;
		List<String> res = getResult(esql, 0);
		boolean existFlag = false;
		for (String dbparation : res) {
			if (dbparation.equalsIgnoreCase(parationStr)) {
				existFlag = true;
			}
		}
		if (!existFlag) {
			log.info("execute [" + "alter table " + tablename + " add partition (p_date='" + parationStr + "');REFRESH " + tablename + ";" + "]");
			exSql("alter table " + tablename + " add partition (p_date='" + parationStr + "');REFRESH " + tablename + ";");
		}
		return !existFlag;
	}

	/**
	 * 
	 * @param sqlQuery
	 * @param cnumber
	 *            column number
	 * @return
	 */
	public List<String> getResult(String sqlQuery, int cnumber) {
		log.info("start execute [" + sqlQuery + "]");
		Connection connection = null;
		List<String> resList = new ArrayList<String>();
		try {
			connection = DatabaseManager.getImpalaConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sqlQuery);
			while (rs.next()) {
				resList.add(rs.getString(1));
			}
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
		return resList;
	}

	/**
	 * c1=cvalue,c2=cvalue
	 * 
	 * @param sqlQuery
	 * @return
	 */
	public String getResultAsKeyVal(String sqlQuery) {
		log.info("start execute [" + sqlQuery + "]");
		Connection connection = null;
		StringBuffer resStr = new StringBuffer();
		try {
			connection = DatabaseManager.getImpalaConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sqlQuery);
			while (rs.next()) {
				resStr.append(rs.getString(1)).append(":").append(rs.getString(2)).append(",");
			}
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
		log.info("resStr:" + resStr);
		if (resStr.length() > 0) {
			return resStr.substring(0, resStr.length() - 1);
		} else {
			return resStr.toString();
		}
	}

	public void exSql(String sqlexc) {
		log.info("start execute [" + sqlexc + "]");
		Connection connection = null;
		try {
			connection = DatabaseManager.getImpalaConnection();
			Statement stmt = connection.createStatement();
			String[] sqls = sqlexc.split(";");
			for (String sql : sqls) {
				stmt.execute(sql);
			}
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

}
