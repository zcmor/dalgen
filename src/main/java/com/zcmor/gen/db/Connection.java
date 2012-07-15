package com.zcmor.gen.db;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

/**
 * ��ԭʼconnection ��һ����װ,���ϲ�һ���������ݸ�ȫ���connection
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

	// �������Ƿ���orcale���ݿ��ṩ������
	public boolean isOracle() {
		try {
			return getMetaData().getDatabaseProductName().equalsIgnoreCase(
					"oracle");
		} catch (SQLException e) {
			logger.warning("���ݿ������쳣");
		}

		return false;
	}

	// ~~~~~~~~~~~~~~~~~������~~~~~~~~~~
	public DatabaseMetaData getMetaData() {
		try {
			return connection.getMetaData();
		} catch (SQLException e) {
			logger.warning("���ݿ������쳣");
		}

		return null;
	}

	public Statement createStatement() {
		try {
			return connection.createStatement();
		} catch (SQLException e) {
			logger.warning("���ݿ������쳣");
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
