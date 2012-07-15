package com.zcmor.gen.model;

import com.zcmor.gen.model.enums.OperateEnum;
import com.zcmor.gen.model.enums.ParamTpyeEnum;

/**
 * �������һ��xml�е�operation��ǩ��
 * <p>
 * <operation name="selectByName" paramtype="primitive" returntype="many"> <sql>
 * <![CDATA[ select birthday,age,id,name from test where name=? ]]> </sql>
 * </operation>
 * 
 * �����û�������һ�����ã�����������Operation�������£� <br>
 * operationName --> selectByName <br>
 * paramType --> ParamTpyeEnum.primitive ��ʾ�����ԭʼ�Ļ������� <br>
 * ReturnValueTypeEnum --> ReturnValueTypeEnum.many ��ʾ����sqlִ�����Ľ���ж��
 * ,�������ͨ��sql�����õ�<br>
 * sqlStr --> select birthday,age,id,name from test where name=? <br>
 * operate -->OperateEnum.SELECT <br>
 * tableName --> ����Ϊtest
 * 
 * <p>
 * 
 * @author chunmao.zhu
 * 
 */
public class Operation {

	/**
	 * �ò���������
	 */
	private String operationName;

	/**
	 * �ò����Ĳ�������
	 */
	private ParamTpyeEnum paramType;

	/**
	 * �ò�����sql ���
	 */
	private String sqlStr;

	/**
	 * ����ö��
	 */
	private OperateEnum operate;

	/**
	 * �����ı���
	 */
	private String tableName;

	/**
	 * operation ��ǩ�е�name����,��Ӧsql-map��xml�е�Id�ֶΡ���name�ĸ�
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
