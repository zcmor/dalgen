package com.zcmor.gen.util;

import org.apache.log4j.Logger;

/**
 * ��logger���а�װ��ʡ��ÿ��ʹ��ǰ��Ҫ�жϡ��������뿪Ҳ�ܽ��͵ķ������Ӷ�
 * 
 * @author chunmao.zhu
 * 
 */
public class LoggerUtil {

	public static void info(Logger logger, Object message) {

		if (logger.isInfoEnabled()) {
			logger.info(message);
		}
	}

	public static void error(Logger logger, Object message) {

		logger.info(message);
	}

	public static void warn(Logger logger, Object message) {

		logger.warn(message);
	}
}
