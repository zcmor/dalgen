package com.zcmor.gen.model;

import com.zcmor.gen.model.enums.OperateEnum;
import com.zcmor.gen.model.enums.ParamTpyeEnum;

/**
 * 该类代表一个xml中的operation标签。
 * <p>
 * <operation name="selectByName" paramtype="primitive" returntype="many"> <sql>
 * <![CDATA[ select birthday,age,id,name from test where name=? ]]> </sql>
 * </operation>
 * 
 * 对于用户这样的一个配置，解析出来的Operation对象如下： <br>
 * operationName --> selectByName <br>
 * paramType --> ParamTpyeEnum.primitive 表示入参是原始的基本类型 <br>
 * ReturnValueTypeEnum --> ReturnValueTypeEnum.many 表示该条sql执行完后的结果有多个
 * ,这个现在通过sql解析得到<br>
 * sqlStr --> select birthday,age,id,name from test where name=? <br>
 * operate -->OperateEnum.SELECT <br>
 * tableName --> 表名为test
 * 
 * <p>
 * 
 * @author chunmao.zhu
 * 
 */
public class Operation {

	/**
	 * 该操作的名称
	 */
	private String operationName;

	/**
	 * 该操作的参数类型
	 */
	private ParamTpyeEnum paramType;

	/**
	 * 该操作的sql 语句
	 */
	private String sqlStr;

	/**
	 * 操作枚举
	 */
	private OperateEnum operate;

	/**
	 * 操作的表名
	 */
	private String tableName;

	/**
	 * operation 标签中的name属性,对应sql-map的xml中的Id字段。将name改改
	 */
	private String sqlId;

	// ~~~~~~~~~~~~~~~~~~~~~~~getters and setters~~~~~~~~~~~~~~~~~~~~~~~~~
	/**
	 * @return the operationName
	 */
	public String getOperationName() {
		return operationName;
	}

	/**
	 * @param operationName
	 *            the operationName to set
	 */
	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}

	/**
	 * @return the sqlStr
	 */
	public String getSqlStr() {
		return sqlStr;
	}

	/**
	 * @param sqlStr
	 *            the sqlStr to set
	 */
	public void setSqlStr(String sqlStr) {
		this.sqlStr = sqlStr;
	}

	/**
	 * @return the operate
	 */
	public OperateEnum getOperate() {
		return operate;
	}

	/**
	 * @param operate
	 *            the operate to set
	 */
	public void setOperate(OperateEnum operate) {
		this.operate = operate;
	}

	/**
	 * @return the tableName
	 */
	public String getTableName() {
		return tableName;
	}

	/**
	 * @param tableName
	 *            the tableName to set
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	/**
	 * @return the sqlId
	 */
	public String getSqlId() {
		return sqlId;
	}

	/**
	 * @param sqlId
	 *            the sqlId to set
	 */
	public void setSqlId(String sqlId) {
		this.sqlId = sqlId;
	}

	public ParamTpyeEnum getParamType() {
		return paramType;
	}

	public void setParamType(ParamTpyeEnum paramType) {
		this.paramType = paramType;
	}

}
