package com.zcmor.gen.xml.parse;

import java.util.List;

import com.zcmor.gen.model.Operation;


/**
 * xml������
 * @author Administrator
 *
 */
interface Xmlparser {

	/**
	 * ����Ӧpath��xml�ļ�����Ϊһ������Operation����
	 * @param path
	 * @return
	 */
	List<Operation> parseXml(String path);
}
