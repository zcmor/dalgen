package com.zcmor.gen.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	/** 年-月-日 小时:分钟:秒 */
	public static final String simpleFormat = "yyyy-MM-dd HH:mm:ss";
	
	/**
	 * 获取当前时间
	 * @return
	 */
	public static String getCurrentTime(){
		
		return getDtSimpleFormat(new Date());
	}
	/**
	 * 获取yyyy-MM-dd 格式数据
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
	 * 获取一个Date 格式化的工具
	 * 
	 * @param format
	 * @return
	 */
	public static DateFormat getFormat(String format) {
		return new SimpleDateFormat(format);
	}

}
