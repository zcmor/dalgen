package com.zcmor.gen.model.enums;

/**
 * operation 标签中的paramtype属性枚举
 * 
 * primitive 表示入参是java的基本类型，如int
 * 
 * object 表示入参是一个对象 如插入的时候传入的有一个DO对象
 * 
 * @author Administrator
 * 
 */
public enum ParamTpyeEnum {
	/** 原始数据类型 */
	primitive("primitive", "原始数据类型"),

	/** 对象类型 */
	object("object", "对象");

	/** 枚举码 */
	private String code;

	/** 枚举的描述 */
	private String desc;

	private ParamTpyeEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * 根据操作码获得操作枚举
	 * 
	 * @param code
	 * @return
	 */
	public static ParamTpyeEnum getEnumByCode(String code) {
		for (ParamTpyeEnum operate : ParamTpyeEnum.values()) {

			if (operate.getCode().equals(code)) {
				return operate;
			}
		}

		return null;
	}
}
