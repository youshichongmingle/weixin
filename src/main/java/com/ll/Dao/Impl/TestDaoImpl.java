package com.ll.Dao.Impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.ll.Dao.TestDao;
import com.ll.bean.Record;
import com.ll.utils.DruidPoolUtil;

public class TestDaoImpl implements TestDao{



	@Override
	public String search(String data, String things) {
		// TODO Auto-generated method stub

		String sql="select * from record where Recordid=?";
		QueryRunner qr = new QueryRunner(DruidPoolUtil.dataSource);
		Object[] params= {data};
		String recordthings = null ;
		try {
			Record query = qr.query(sql, new BeanHandler<Record>(Record.class),data);
//			System.out.println(query);
			
			if(query==null){
				System.out.println("数据库没有");
				insert(data,things);
			}
			else {
				add(data, things);
				System.out.println("数据库有");
				recordthings=query.getRecordthings();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(recordthings);
		return recordthings;
	}
	
	
	public void insert(String data, String things) {
		String sql="insert into  record  values(?,?)";
		QueryRunner qr = new QueryRunner(DruidPoolUtil.dataSource);
		Object[] params= {data,things};
		try {
			Record insert = qr.insert(sql, new BeanHandler<Record>(Record.class), params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	
	public void add(String data, String things) {
		String sql="update record set Recordthings=? where  Recordid=?";
		QueryRunner qr = new QueryRunner(DruidPoolUtil.dataSource);
		Object[] params= {things,data};
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public Record querer(String data) {
		// TODO Auto-generated method stub

		String sql="select * from record where Recordid=?";
		QueryRunner qr = new QueryRunner(DruidPoolUtil.dataSource);
		Object[] params= {data};
		String recordthings = null ;
		Record query = null;
		try {
			 query = qr.query(sql, new BeanHandler<Record>(Record.class),data);
//			System.out.println(query);
			
			if(query==null){
				System.out.println("数据库没有");
//				recordthings="kong";
			}
			else {
			
//				recordthings=query.getRecordthings();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		System.out.println(recordthings);
		return query;
	} 

	
}
