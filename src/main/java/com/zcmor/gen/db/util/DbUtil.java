/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.zcmor.gen.db.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import com.zcmor.gen.db.Connection;
import com.zcmor.gen.util.Assert;

/**
 * 数据库类型判断工具类
 * 
 * @author gody
 * @version $Id: DatabaseTypeUtils.java, v 0.1 2012-5-14 下午04:59:06 gody Exp $
 */
public class DbUtil {

	private static final Logger logger = Logger.getLogger(DbUtil.class
			.getName());

	/**
	 * 获取orcal数据库某个表的某个字段的注释
	 * 
	 * @param tableName
	 * @param columnName
	 * @return
	 */
	public static String fetchOracleColumnComment(Connection conn,
			String tableName, String columnName) {

		Assert.notNull(conn);
		Assert.notNull(tableName);
		Assert.notNull(columnName);

		/** orcale数据库的注释查询方法 */
		String sql = "SELECT comments FROM user_col_comments WHERE table_name='"
				+ tableName.trim()
				+ "' AND column_name = '"
				+ columnName.trim() + "'";

		return queryForString(conn, sql);
	}

	/**
	 * 获取某个数据库表的注释
	 * 
	 * @param conn
	 * @param tableName
	 * @return
	 */
	public static String getOracleTableComment(Connection conn, String tableName) {
		Assert.notNull(conn);
		Assert.notNull(tableName);

		String sql = "SELECT comments FROM user_col_comments WHERE table_name='"
				+ tableName.trim() + "'";

		return queryForString(conn, sql);
	}

	/**
	 * 根据sql查询数据库中的值
	 * 
	 * @param conn
	 * @param sql
	 * @return
	 */
	public static String queryForString(Connection conn, String sql) {
		Statement s = null;
		ResultSet rs = null;
		try {
			s = conn.createStatement();
			rs = s.executeQuery(sql);
			if (rs.next()) {
				return rs.getString(1);
			}
			return null;
		} catch (SQLException e) {
			logger.warning("数据库查询出错");
			return null;
		} finally {
			DbColseHelper.close(null, s, rs);
		}
	}
}
