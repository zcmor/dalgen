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
 * 默认实现的xml解析器
 * 
 * @author Administrator
 * 
 */
public class DefaultXmlParser implements Xmlparser {
	/**
	 * 记录日志
	 */
	private static final Logger logger = Logger
			.getLogger(DefaultXmlParser.class);

	/**
	 * sql解析器
	 */
	private SqlParser sqlParser;

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~接口方法~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public List<Operation> parseXml(String path) {
		List<Operation> lists = new ArrayList<Operation>();

		List<Element> eles = parseOpElements(parseRootElement(path));
		for (Element ele : eles) {
			lists.add(convert(ele));
		}

		return lists;
	}

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~内部方法~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	/**
	 * 解析xml中的operation节点
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
	 * 解析该xml中的根元素
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
			logger.error("解析xml发生错误", e);

			return null;
		}
		Element rootNode = document.getRootElement();

		return rootNode;
	}

	/**
	 * 将Element转换为Operation对象
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
		// operation.setTableName(parseTableName(path));这个元素先空着，等到sql解析的时候再填充
		return operation;
	}

	// ~~~~~~~~~~~~~~~~~~~~~容器方法~~~~~~~~~~~~~~~~~~~~~~~~~~~~
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
