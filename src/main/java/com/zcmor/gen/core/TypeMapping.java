/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.zcmor.gen.core;

import java.util.HashMap;
import java.util.Map;

import com.zcmor.gen.util.Assert;

/**
 * ���ݿ��ֶ�������java����ӳ���ϵ��
 * 
 * @author gody
 * @version $Id: TypeMapping.java, v 0.1 2012-5-14 ����09:26:23 gody Exp $
 */
public class TypeMapping {

	/** ���JDBC type��java ���ͼ�д��ӳ���ϵ */
	private static Map<String, String> shortType = new HashMap<String, String>();

	/** ���JDBC type ��java ����ȫд��ӳ���ϵ */
	private static Map<String, String> fullType = new HashMap<String, String>();

	// /** ��Ų�������OperateEnum��IbatisMethodNameӳ���ϵ */
	// private static Map<String, IbatisMethodEnum> methodNameMapping = new
	// HashMap<String, IbatisMethodEnum>();
	static {

		// ~~~~~~init shortType map
		shortType.put("DATETIME", "Date");
		shortType.put("timestamp", "Date");
		shortType.put("NUMBER", "Money");
		shortType.put("INT", "int");
		shortType.put("integer", "int");
		shortType.put("VARCHAR", "String");
		shortType.put("text", "String");

		// ~~~~~~init fullType map
		fullType.put("DATETIME", "java.util.Date");
		fullType.put("timestamp", "java.util.Date");
		fullType.put("NUMBER", "Money");
		fullType.put("INT", "int");
		fullType.put("integer", "int");
		fullType.put("VARCHAR", "java.lang.String");
		fullType.put("text", "java.lang.String");

		// ~~~~~~init methodNameMapping map
		// methodNameMapping.put(OperateEnum.DELETE.getCode(),
		// IbatisMethodEnum.DELETE);
		// methodNameMapping.put(OperateEnum.INSERT.getCode(),
		// IbatisMethodEnum.INSERT);
		// methodNameMapping.put(OperateEnum.UPDATE.getCode(),
		// IbatisMethodEnum.UPDATE);
		//
		// methodNameMapping.put(OperateEnum.SELECT.getCode()
		// + ResultTypeEnum.LIST.getCode(), IbatisMethodEnum.QUERYFORLIST);
		// methodNameMapping.put(OperateEnum.SELECT.getCode()
		// + ResultTypeEnum.PRIMITIVE.getCode(),
		// IbatisMethodEnum.QUERYFORLIST);
	}

	/**
	 * ����jdbcType�����ͻ�ȡ��Ӧ��java����
	 * 
	 * @param jdbcType
	 * @return
	 */
	public static String fetchJavaType(String jdbcType) {
		Assert.notNull(jdbcType);
		return shortType.get(jdbcType.trim());
	}

	/**
	 * ����jdbcType�����ͻ�ȡ��Ӧ��java���͵�ȫ��
	 * 
	 * @param jdbcType
	 * @return
	 */
	public static String fetchFullJavaType(String jdbcType) {
		Assert.notNull(jdbcType);
		return fullType.get(jdbcType.trim());
	}

	/**
	 * ���ݲ������ͺͷ��ؽ���õ���Ӧ��ibatisӦ�õ��õķ���
	 * 
	 * @param op
	 * @param res
	 * @return
	 */
	// public static String fetchMethodName(OperateEnum op, ResultTypeEnum res)
	// {
	// if (op == null) {
	// return "";
	// }
	// String key = op.getCode() + res == null ? "" : res.getCode();
	// IbatisMethodEnum method = methodNameMapping.get(key.trim());
	//
	// return method.getCode();
	// }
}
