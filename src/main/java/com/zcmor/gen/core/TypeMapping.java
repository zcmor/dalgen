/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.zcmor.gen.core;

import java.util.HashMap;
import java.util.Map;

import com.zcmor.gen.util.Assert;

/**
 * 数据库字段类型与java类型映射关系类
 * 
 * @author gody
 * @version $Id: TypeMapping.java, v 0.1 2012-5-14 下午09:26:23 gody Exp $
 */
public class TypeMapping {

	/** 存放JDBC type与java 类型简写的映射关系 */
	private static Map<String, String> shortType = new HashMap<String, String>();

	/** 存放JDBC type 与java 类型全写的映射关系 */
	private static Map<String, String> fullType = new HashMap<String, String>();

	// /** 存放操作类型OperateEnum与IbatisMethodName映射关系 */
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
	 * 根据jdbcType的类型获取对应的java类型
	 * 
	 * @param jdbcType
	 * @return
	 */
	public static String fetchJavaType(String jdbcType) {
		Assert.notNull(jdbcType);
		return shortType.get(jdbcType.trim());
	}

	/**
	 * 根据jdbcType的类型获取对应的java类型的全名
	 * 
	 * @param jdbcType
	 * @return
	 */
	public static String fetchFullJavaType(String jdbcType) {
		Assert.notNull(jdbcType);
		return fullType.get(jdbcType.trim());
	}

	/**
	 * 根据操作类型和返回结果拿到对应的ibatis应该调用的方法
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
