/**
 * 该包主要是负责解析Operations.xml。
 * 
 * 一个典型的operation.xml是类似这样的文件
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
   
   用户也只需要些这样的一个xml文件，程序就能自动解析出DO对象，并生成相应的ibatis代码
 */
package com.zcmor.gen.xml;