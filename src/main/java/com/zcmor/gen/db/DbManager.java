package com.zcmor.gen.db;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 * 数据库相关操作的管理类
 * 
 * @author Administrator
 * 
 */
public class DbManager {

	private static final Logger logger = Logger.getLogger(DbManager.class
			.getName());

	public static Connection getConnection() {

		// TODO load from propertites
		// String jdbcUrl = "jdbc:sqlite:c:/SQLite/test.db";
		// String jdbcDriver = "org.sqlite.JDBC";
		String jdbcUrl = "jdbc:mysql://localhost:3306/test?user=root&password=123456&useUnicode=true&characterEncoding=gbk";
		String jdbcDriver = "com.mysql.jdbc.Driver";
		try {
			Class.forName(jdbcDriver);
		} catch (ClassNotFoundException e) {
			logger.warning(jdbcUrl + "不能加载,请检查classpath中是否包含该jar");

			return null;
		}

		Connection conn;
		try {
			conn = new com.zcmor.gen.db.Connection(
					DriverManager.getConnection(jdbcUrl));
			return conn;
		} catch (SQLException e) {
			logger.warning("数据库连接异常,不能获取到可用连接");
		}
		return null;
	}
}
