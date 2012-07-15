package com.zcmor.gen.xml.parse;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.zcmor.gen.model.Operation;
import com.zcmor.gen.model.enums.ParamTpyeEnum;
import com.zcmor.gen.sql.parse.SqlParser;

/**
 * Ĭ��ʵ�ֵ�xml������
 * 
 * @author Administrator
 * 
 */
public class DefaultXmlParser implements Xmlparser {
	/**
	 * ��¼��־
	 */
	private static final Logger logger = Logger
			.getLogger(DefaultXmlParser.class);

	/**
	 * sql������
	 */
	private SqlParser sqlParser;

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~�ӿڷ���~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public List<Operation> parseXml(String path) {
		List<Operation> lists = new ArrayList<Operation>();

		List<Element> eles = parseOpElements(parseRootElement(path));
		for (Element ele : eles) {
			lists.add(convert(ele));
		}

		return lists;
	}

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~�ڲ�����~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	/**
	 * ����xml�е�operation�ڵ�
	 * 
	 * @param path
	 * @return
	 */
	private List<Element> parseOpElements(Element rootEle) {
		if (rootEle == null) {
			return new ArrayList<Element>();
		}

		@SuppressWarnings("rawtypes")
		List list = rootEle.selectNodes("operation");
		List<Element> result = new ArrayList<Element>();
		for (int index = 0; index < list.size(); index++) {
			Element subEle = (Element) list.get(index);
			result.add(subEle);
		}
		return result;
	}

	/**
	 * ������xml�еĸ�Ԫ��
	 * 
	 * @param path
	 * @return
	 */
	private Element parseRootElement(String path) {
		SAXReader saxReader = new SAXReader();
		Document document;
		try {
			document = saxReader.read(path);
		} catch (DocumentException e) {
			logger.error("����xml��������", e);

			return null;
		}
		Element rootNode = document.getRootElement();

		return rootNode;
	}

	/**
	 * ��Elementת��ΪOperation����
	 * 
	 * @param subEle
	 * @return
	 */
	private Operation convert(Element subEle) {
		Operation operation = new Operation();
		operation.setOperationName(subEle.attributeValue("name"));
		@SuppressWarnings("rawtypes")
		List subList = subEle.selectNodes("sql");
		Element ele = (Element) subList.get(0);
		String sql = ele.getTextTrim();
		operation.setParamType(ParamTpyeEnum.getEnumByCode(subEle
				.attributeValue("paramtype")));
		operation.setOperate(sqlParser.parseOperateType(sql));
		operation.setSqlStr(sqlParser.parse(sql));
		// operation.setTableName(parseTableName(path));���Ԫ���ȿ��ţ��ȵ�sql������ʱ�������
		return operation;
	}

	// ~~~~~~~~~~~~~~~~~~~~~��������~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/**
	 * @return the sqlParser
	 */
	public SqlParser getSqlParser() {
		return sqlParser;
	}

	/**
	 * @param sqlParser
	 *            the sqlParser to set
	 */
	public void setSqlParser(SqlParser sqlParser) {
		this.sqlParser = sqlParser;
	}
}
