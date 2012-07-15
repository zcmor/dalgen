package com.zcmor.gen.model.enums;

/**
 * operation ��ǩ�е�paramtype����ö��
 * 
 * primitive ��ʾ�����java�Ļ������ͣ���int
 * 
 * object ��ʾ�����һ������ ������ʱ�������һ��DO����
 * 
 * @author Administrator
 * 
 */
public enum ParamTpyeEnum {
	/** ԭʼ�������� */
	primitive("primitive", "ԭʼ��������"),

	/** �������� */
	object("object", "����");

	/** ö���� */
	private String code;

	/** ö�ٵ����� */
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
	 * ���ݲ������ò���ö��
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
