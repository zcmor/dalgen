/**
 * �ð���Ҫ�Ǹ������Operations.xml��
 * 
 * һ�����͵�operation.xml�������������ļ�
 * <?xml version="1.0" encoding="UTF-8"?>
	<table sqlname="test">

	<operation name="selectAll" paramtype="primitive">
		<sql>
			<![CDATA[
			 select * from test where id=?
			]]>
		</sql>
	</operation>
	
	<operation name="selectById" paramtype="primitive">
		<sql>
			<![CDATA[
			 select birthday,age,id,name from test where name=? 
			]]>
		</sql>
	</operation>
   </table>
   
   �û�Ҳֻ��ҪЩ������һ��xml�ļ�����������Զ�������DO���󣬲�������Ӧ��ibatis����
 */
package com.zcmor.gen.xml;