package com.zcmor.gen.xml.parse;

import java.util.List;

import com.zcmor.gen.model.Operation;


/**
 * xml解析器
 * @author Administrator
 *
 */
interface Xmlparser {

	/**
	 * 将相应path的xml文件解析为一个个的Operation对象
	 * @param path
	 * @return
	 */
	List<Operation> parseXml(String path);
}
