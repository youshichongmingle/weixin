package com.ll.test;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ll.Dao.Impl.TestDaoImpl;
import com.ll.bean.Record;
import com.ll.utils.DruidPoolUtil;

public class Tset {
	@Test
	public void test() {
		String sql="select * from record where Recordid='1'";
		QueryRunner qr = new QueryRunner(DruidPoolUtil.dataSource);
//		Object[] params= {};
		try {
			Record query = qr.query(sql, new BeanHandler<Record>(Record.class));
//			qr.qu
			System.out.println(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void tt() {
		TestDaoImpl tt=new TestDaoImpl();
//		tt.insert("2", "2");
//		tt.add("2", "445");
		String search = tt.search("2","2");
	}
	
	@Test
	public void aa() {
		String aa="奥术大师大所大所";
		ObjectMapper om=new ObjectMapper();
		String ws = null;
		try {
			ws = om.writeValueAsString(aa);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			String value = new String(ws.getBytes( "UTF-8"),"ISO-8859-1");
			System.out.println(value);
			
			
			System.out.println(ws);
			
			String value1 = new String(ws.getBytes( "UTF-8"),"gbk");
			System.out.println(value1);
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
