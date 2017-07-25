package com.blog.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;


public final class DatabaseUtil {

	private static Connection conn;

	private DatabaseUtil() {
	}

	static {

		try {
			
			System.out.println(DatabaseUtil.class.getClassLoader().getResource("/"));
			
			InputStream fis = DatabaseUtil.class.getClassLoader().getResourceAsStream("database.properties");
			
			
			Properties pro = new Properties();
			
			pro.load(fis);
			
			String user = pro.getProperty("user");
			
			String passwd = pro.getProperty("passwd");
			
			String url = pro.getProperty("url");
			
			System.out.println(user+":"+passwd+":"+url);
			
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection(url, user, passwd);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("类不存在");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("获取连接失败");
			e.printStackTrace();
		}

	}

	public static Connection getConn() {
		return conn;
	}
	
	public static void closeConn(){
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static PreparedStatement getStatement(Connection conn,String sql) {

		try {

			PreparedStatement preStm = conn.prepareStatement(sql);

			return preStm;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
}
