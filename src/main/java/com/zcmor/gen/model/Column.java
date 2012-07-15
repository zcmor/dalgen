package com.zcmor.gen.model;

/**
 * ��Ӧ���ݿ������ģ��
 * 
 * @author Administrator
 * 
 */
public class Column {

	/**
	 * Reference to the containing table
	 */
	private Table table;

	/**
	 * The java.sql.Types type����70
	 */
	private int sqlType;

	/**
	 * The sql typename. provided by JDBC driver.��int,varchar
	 */
	private String sqlTypeName;

	/**
	 * the java type for the sql short type.ӳ�䵽java�е����͡���int,String
	 */
	private String javaTypeName;

	/**
	 * the java type for the sql full type.ӳ�䵽java�е�����ȫ������java.lang.String
	 */
	private String javaFullTypeName;

	/**
	 * The name of the column.�е�����
	 */
	private String colName;

	/**
	 * Null if the DB reports no default value�����е�Ĭ��ֵ
	 */
	private String defaultValue;

	/**
	 * The comments of column�����еı�ע
	 */
	private String remarks;

	// ~~~~~~~~~~~~~~~getters and setters ~~~~~~~~~~~~~

	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}

	public int getSqlType() {
		return sqlType;
	}

	public void setSqlType(int sqlType) {
		this.sqlType = sqlType;
	}

	public String getSqlTypeName() {
		return sqlTypeName;
	}

	public void setSqlTypeName(String sqlTypeName) {
		this.sqlTypeName = sqlTypeName;
	}

	public String getJavaTypeName() {
		return javaTypeName;
	}

	public void setJavaTypeName(String javaTypeName) {
		this.javaTypeName = javaTypeName;
	}

	public String getJavaFullTypeName() {
		return javaFullTypeName;
	}

	public void setJavaFullTypeName(String javaFullTypeName) {
		this.javaFullTypeName = javaFullTypeName;
	}

	public String getColName() {
		return colName;
	}

	public void setColName(String colName) {
		this.colName = colName;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
