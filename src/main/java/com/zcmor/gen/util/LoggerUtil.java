package com.zcmor.gen.util;

import org.apache.log4j.Logger;

/**
 * 对logger进行包装，省得每次使用前都要判断。这样隔离开也能降低的方法复杂度
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
