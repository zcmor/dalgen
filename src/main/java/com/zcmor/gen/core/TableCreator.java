package com.zcmor.gen.core;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.log4j.Logger;

import com.zcmor.gen.db.Connection;
import com.zcmor.gen.db.DbManager;
import com.zcmor.gen.db.util.DbUtil;
import com.zcmor.gen.model.Column;
import com.zcmor.gen.model.Table;
import com.zcmor.gen.util.LoggerUtil;

/**
 * �������ݿ����Ϣ����table����
 * 
 * @author chunmao.zhu
 * 
 */
public class TableCreator {
	private static final Logger logger = Logger.getLogger(TableCreator.class);

	/**
	 * ���ݱ�������table����
	 * 
	 * @param catalog
	 * @param schema
	 * @param name
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public Table createTableByName(String catalog, String schema, String name) {
		Connection conn = DbManager.getConnection();
		DatabaseMetaData dbMetaData;
		try {
			dbMetaData = conn.getMetaData();

			ResultSet rs = dbMetaData.getTables(catalog, schema, name, null);

			rs.next();

			Table table = createTable(catalog, conn, rs);

			return table;
		} catch (Exception e) {
			LoggerUtil.error(logger, e);
			return null;
		}
	}

	/**
	 * ����table����
	 * 
	 * @param catalog
	 * @param conn
	 * @param rs
	 * @return
	 */
	public Table createTable(String catalog, Connection conn, ResultSet rs) {
		// ��ȡ�������Ϣ
		String schemaName, tableName, remarks;

		try {
			schemaName = rs.getString("TABLE_SCHEM") == null ? "" : rs
					.getString("TABLE_SCHEM");
			tableName = rs.getString("TABLE_NAME").toLowerCase();
			remarks = rs.getString("REMARKS");
			if (remarks == null && conn.isOracle()) {
				remarks = DbUtil.getOracleTableComment(conn, tableName);
			}
		} catch (SQLException e) {
			LoggerUtil.error(logger, e);
			return null;
		}

		Table table = new Table();
		table.setTableName(tableName);
		table.setCatalog(catalog);
		table.setSchema(schemaName);
		table.setRemarks(remarks);

		fillTable(table, conn);

		return table;
	}

	/**
	 * ���table����
	 * 
	 * @param table
	 * @param conn
	 */
	public void fillTable(Table table, Connection conn) {
		handleCommonCol(table, conn);

		handlePkCol(table, conn.getMetaData());

		handleUniqCol(table, conn.getMetaData());
	}

	/**
	 * ������ͨ�е����
	 * 
	 * @param table
	 * @param dbMetaData
	 * @param conn
	 * @throws SQLException
	 */
	private static void handleCommonCol(Table table, Connection conn) {
		ResultSet columnRs;
		try {
			columnRs = conn.getMetaData().getColumns(table.getCatalog(),
					table.getSchema(), table.getTableName(), null);
		} catch (SQLException e) {
			LoggerUtil.error(logger, e);
			return;
		}

		Set<Column> columns = new LinkedHashSet<Column>();
		try {
			while (columnRs.next()) {
				int sqlType = columnRs.getInt("DATA_TYPE");
				String sqlTypeName = columnRs.getString("TYPE_NAME");
				String columnName = columnRs.getString("COLUMN_NAME");
				String columnDefaultValue = columnRs.getString("COLUMN_DEF");
				String remarks = columnRs.getString("REMARKS");

				if (remarks == null && conn.isOracle()) {
					remarks = DbUtil.fetchOracleColumnComment(conn,
							table.getTableName(), columnName);
				}

				Column column = new Column();
				column.setTable(table);
				column.setColName(columnName);
				column.setSqlType(sqlType);
				column.setSqlTypeName(sqlTypeName);
				column.setRemarks(remarks == null ? "" : remarks);
				column.setDefaultValue(columnDefaultValue == null ? ""
						: columnDefaultValue);
				column.setJavaTypeName(TypeMapping.fetchJavaType(sqlTypeName));
				column.setJavaFullTypeName(TypeMapping
						.fetchFullJavaType(sqlTypeName));

				columns.add(column);
			}
		} catch (SQLException e) {
			LoggerUtil.error(logger, e);
		}

		table.setColumns(columns);
	}

	/**
	 * ���������е����
	 * 
	 * @param table
	 * @param dbMetaData
	 * @param conn
	 * @throws SQLException
	 */
	private static void handlePkCol(Table table, DatabaseMetaData dbMetaData) {
		ResultSet keyColumnRs;
		try {
			keyColumnRs = dbMetaData.getPrimaryKeys(table.getCatalog(),
					table.getSchema(), table.getTableName());
			Set<Column> columns = handleSpecial(keyColumnRs, table);

			table.setPkColumns(columns);
		} catch (SQLException e) {
			LoggerUtil.error(logger, e);
		}

	}

	/**
	 * ����Ψһ�Լ������,Ψһ�Լ�����������
	 * 
	 * @param table
	 * @param dbMetaData
	 * @param conn
	 * @throws SQLException
	 */
	private static void handleUniqCol(Table table, DatabaseMetaData dbMetaData) {
		try {
			ResultSet uniqueColumnRs = dbMetaData.getIndexInfo(
					table.getCatalog(), table.getSchema(),
					table.getTableName(), true, true);

			Set<Column> columns = handleSpecial(uniqueColumnRs, table);

			table.setUniqColumns(columns);
		} catch (SQLException e) {
			LoggerUtil.error(logger, "not yet implements interfaces");
		}
	}

	/**
	 * ������������,��Ҫ�ǳ�ȡ��������Ψһ��Լ���� ��ȡ��ʽ���õ������б�Ȼ���table�����е��н���ƥ�䡣
	 * 
	 * @param rs
	 * @throws SQLException
	 */
	private static Set<Column> handleSpecial(ResultSet rs, Table table) {
		Set<Column> columns = new LinkedHashSet<Column>();
		try {
			while (rs.next()) {
				String columnName = rs.getString("COLUMN_NAME");
				for (Column col : table.getColumns()) {
					if (col.getColName().equals(columnName)) {
						columns.add(col);
						break;
					}
				}
			}
		} catch (SQLException e) {
			LoggerUtil.error(logger, e);
		}

		return columns;
	}
}
