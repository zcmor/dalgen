package com.zcmor.gen.model;

import java.util.Set;

/**
 * 数据库表对应模型
 * 
 * @author Administrator
 * 
 */
public class Table {
	/** 表名 */
	private String tableName;

	/** 表注释 */
	private String remarks;

	/** 映射到的类名 */
	private String className;

	/** catalog */
	private String catalog;

	/** schema */
	private String schema;

	/** 包含的所有列 */
	private Set<Column> columns;

	/** 唯一索引列,包含了主键列 */
	private Set<Column> uniqColumns;

	/** 主键列 */
	private Set<Column> pkColumns;

	// ~~~~~~~~~~~~~~~~~`getters and setters~~~~~~~~~~~~~~~~~~~~~~~~~~
	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getCatalog() {
		return catalog;
	}

	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}

	public String getSchema() {
		return schema;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}

	public Set<Column> getColumns() {
		return columns;
	}

	public void setColumns(Set<Column> columns) {
		this.columns = columns;
	}

	public Set<Column> getUniqColumns() {
		if (uniqColumns == null) {
			return pkColumns;
		}
		return uniqColumns;
	}

	public void setUniqColumns(Set<Column> uniqColumns) {
		this.uniqColumns = uniqColumns;
	}

	public Set<Column> getPkColumns() {
		return pkColumns;
	}

	public void setPkColumns(Set<Column> pkColumns) {
		this.pkColumns = pkColumns;
	}

}
