package com.sect.datax.logreport.base;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DatabaseManager {
	private static Logger log = Logger.getLogger(DatabaseManager.class);

	private static ComboPooledDataSource mysqlDBS = new ComboPooledDataSource();

	public static void init() {
		log.info("start to init mysql database......");
		mysqlDBS.setJdbcUrl(ConfigLoader.getProperty("mysql.jdbcUrl"));
		try {
			mysqlDBS.setDriverClass(ConfigLoader.getProperty("mysql.driverClass"));
		} catch (PropertyVetoException e) {
			log.error("database init error:" + e);
		}
		mysqlDBS.setUser(ConfigLoader.getProperty("mysql.user"));
		mysqlDBS.setPassword(ConfigLoader.getProperty("mysql.password"));
		mysqlDBS.setMinPoolSize(Integer.parseInt(ConfigLoader.getProperty("mysql.minPoolSize")));
		mysqlDBS.setMaxPoolSize(Integer.parseInt(ConfigLoader.getProperty("mysql.maxPoolSize")));

		log.info("database success inited.....");
	}

	public static JdbcTemplate getMySqlJdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(mysqlDBS);
		return jdbcTemplate;
	}

	public static Connection getMysqlConnection() throws SQLException {
		return mysqlDBS.getConnection();
	}

	public static Connection getImpalaConnection() throws SQLException, ClassNotFoundException {
		Connection connection = null;
		Class.forName(ConfigLoader.getProperty("impala.driverClass"));
		connection = DriverManager.getConnection(ConfigLoader.getProperty("impala.jdbcUrl"));
		return connection;
	}
}