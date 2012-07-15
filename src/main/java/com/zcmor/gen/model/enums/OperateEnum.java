package com.zcmor.gen.model.enums;

/**
 * ���ݿ����ö��
 * 
 * @author Administrator
 * 
 */
public enum OperateEnum {

	/** ��ѯ���� */
	SELECT("select", "��ѯ"),

	/** ɾ������ */
	DELETE("delete", "ɾ��"),

	/** ���²��� */
	UPDATE("update", "����"),

	/** ������� */
	INSERT("insert", "����");

	/** ö���� */
	private String code;

	/** ö�ٵ����� */
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
	 * ���ݲ������ò���ö��
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
