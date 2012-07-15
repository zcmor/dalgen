package com.zcmor.gen.db;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

/**
 * 对原始connection 的一个包装,给上层一个基础数据更全面的connection
 * 
 * @author Administrator
 * 
 */
public class Connection {

	private static final Logger logger = Logger.getLogger(Connection.class
			.getName());

	private java.sql.Connection connection;

	/**
	 * @param connection
	 */
	public Connection(java.sql.Connection connection) {
		super();
		this.connection = connection;
	}

	// 该连接是否是orcale数据库提供的连接
	public boolean isOracle() {
		try {
			return getMetaData().getDatabaseProductName().equalsIgnoreCase(
					"oracle");
		} catch (SQLException e) {
			logger.warning("数据库连接异常");
		}

		return false;
	}

	// ~~~~~~~~~~~~~~~~~代理方法~~~~~~~~~~
	public DatabaseMetaData getMetaData() {
		try {
			return connection.getMetaData();
		} catch (SQLException e) {
			logger.warning("数据库连接异常");
		}

		return null;
	}

	public Statement createStatement() {
		try {
			return connection.createStatement();
		} catch (SQLException e) {
			logger.warning("数据库连接异常");
		}

		return null;
	}

	// ~~~~~~~~~~~~~~~~~setters and getters~~~~~~~~~~~~~~~~~
	// get the original connection
	public java.sql.Connection getConnection() {
		return connection;
	}

	public void setConnection(java.sql.Connection connection) {
		this.connection = connection;
	}

}
