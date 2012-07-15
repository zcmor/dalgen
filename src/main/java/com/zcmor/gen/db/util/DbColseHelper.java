package com.zcmor.gen.db.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * DB操作相关的工具类，主要是封装了关闭数据库资源的操作
 * 
 * @author gody
 * @version $Id: DBHelper.java, v 0.1 2012-5-7 上午08:51:06 gody Exp $
 */
public class DbColseHelper {

	/**
	 * 关闭数据库连接，如果抛出异常则忽视
	 * 
	 * @param conn
	 */
	public static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				// ignore
			}
		}
	}

	/**
	 * 关闭PreparedStatement，如果抛出异常则忽视
	 * 
	 * @param s
	 */
	public static void close(PreparedStatement s) {
		if (s != null) {
			try {
				s.close();
			} catch (Exception e) {
				// ignore
			}
		}
	}

	/**
	 * 关闭Statement，如果抛出异常则忽视
	 * 
	 * @param s
	 */
	public static void close(Statement s) {
		if (s != null) {
			try {
				s.close();
			} catch (Exception e) {
				// ignore
			}
		}
	}

	/**
	 * 关闭ResultSet，如果抛出异常则忽视
	 * 
	 * @param s
	 */
	public static void close(ResultSet s) {
		if (s != null) {
			try {
				s.close();
			} catch (Exception e) {
				// ignore
			}
		}
	}

	/**
	 * 关闭conn和ResultSet，如果抛出异常则忽视
	 * 
	 * @param conn
	 * @param rs
	 */
	public static void close(Connection conn, ResultSet rs) {
		close(conn);
		close(rs);
	}

	/**
	 * 关闭conn，ResultSet，PreparedStatement，如果抛出异常则忽视
	 * 
	 * @param conn
	 * @param ps
	 * @param rs
	 */
	public static void close(Connection conn, PreparedStatement ps, ResultSet rs) {
		close(conn);
		close(ps);
		close(rs);
	}

	/**
	 * 关闭ResultSet，PreparedStatement，如果抛出异常则忽视
	 * 
	 * @param ps
	 * @param rs
	 */
	public static void close(PreparedStatement ps, ResultSet rs) {
		close(ps);
		close(rs);
	}

	/**
	 * 关闭conn,ResultSet，Statement，如果抛出异常则忽视
	 * 
	 * @param conn
	 * @param s
	 * @param rs
	 */
	public static void close(Connection conn, Statement s, ResultSet rs) {
		close(conn);
		close(s);
		close(rs);
	}

	/**
	 * 关闭ResultSet，Statement，如果抛出异常则忽视
	 * 
	 * @param s
	 * @param rs
	 */
	public static void close(Statement s, ResultSet rs) {
		close(s);
		close(rs);
	}

	/**
	 * 回滚操作
	 * 
	 * @param conn
	 */
	public static void rollback(Connection conn) {
		if (conn != null) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				throw new RuntimeException("rollback occer error", e);
			}
		}
	}
}
