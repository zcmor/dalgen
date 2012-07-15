package com.zcmor.gen.model;

import java.util.Set;

/**
 * ���ݿ���Ӧģ��
 * 
 * @author Administrator
 * 
 */
public class Table {
	/** ���� */
	private String tableName;

	/** ��ע�� */
	private String remarks;

	/** ӳ�䵽������ */
	private String className;

	/** catalog */
	private String catalog;

	/** schema */
	private String schema;

	/** ������������ */
	private Set<Column> columns;

	/** Ψһ������,������������ */
	private Set<Column> uniqColumns;

	/** ������ */
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
