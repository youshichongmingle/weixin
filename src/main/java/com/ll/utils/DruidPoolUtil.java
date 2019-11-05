package com.ll.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class DruidPoolUtil {
	
	private static Properties props = new Properties();
	public static DataSource dataSource;
	
	static {
		InputStream is = DruidPoolUtil.class.getClassLoader().getResourceAsStream("druid.properties");
		try {
			props.load(is);
			dataSource = DruidDataSourceFactory.createDataSource(props);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getCon() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
