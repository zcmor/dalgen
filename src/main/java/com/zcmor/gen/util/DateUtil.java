package com.zcmor.gen.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	/** ��-��-�� Сʱ:����:�� */
	public static final String simpleFormat = "yyyy-MM-dd HH:mm:ss";
	
	/**
	 * ��ȡ��ǰʱ��
	 * @return
	 */
	public static String getCurrentTime(){
		
		return getDtSimpleFormat(new Date());
	}
	/**
	 * ��ȡyyyy-MM-dd ��ʽ����
	 * 
	 * @param date
	 * @return
	 */
	public static String getDtSimpleFormat(Date date) {
		if (date == null) {
			return "";
		}
		return getFormat(simpleFormat).format(date);
	}
	/**
	 * ��ȡһ��Date ��ʽ���Ĺ���
	 * 
	 * @param format
	 * @return
	 */
	public static DateFormat getFormat(String format) {
		return new SimpleDateFormat(format);
	}

}
