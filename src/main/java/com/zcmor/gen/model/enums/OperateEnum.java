package com.zcmor.gen.model.enums;

/**
 * 数据库操作枚举
 * 
 * @author Administrator
 * 
 */
public enum OperateEnum {

	/** 查询操作 */
	SELECT("select", "查询"),

	/** 删除操作 */
	DELETE("delete", "删除"),

	/** 更新操作 */
	UPDATE("update", "更新"),

	/** 插入操作 */
	INSERT("insert", "插入");

	/** 枚举码 */
	private String code;

	/** 枚举的描述 */
	private String desc;

	private OperateEnum(String code, String desc) {
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
	public static OperateEnum getEnumByCode(String code) {
		for (OperateEnum operate : OperateEnum.values()) {

			if (operate.getCode().equals(code)) {
				return operate;
			}
		}

		return null;
	}
}
