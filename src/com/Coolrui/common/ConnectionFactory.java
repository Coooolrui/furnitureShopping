package com.Coolrui.common;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory {
	private static String DRIVER;
	private static String URL;
	private static String NAME;
	private static String PASS;

	static {

		//创建Properties文件操作类
		Properties prop = new Properties();
		try {
			//指定文件路径
//			prop.load(new FileReader("src/com/oracle/xb/common/jdbcinfo.properties"));

			//这是第二种方式，不用指定绝对路径，只需要读取的文件和本文件在同一个文件夹下
			prop.load(ConnectionFactory.class.getResourceAsStream("jdbcinfo.properties"));

			//根据k值取得V值
			DRIVER =prop.getProperty("driver");
			URL = prop.getProperty("url");
			NAME = prop.getProperty("name");
			PASS = prop.getProperty("pass");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		System.out.println(DRIVER);

	}


	public static Connection getConnection() {
		Connection conn = null;
		// 1、
		try {
			Class.forName(DRIVER);
			// 2、
			conn = DriverManager.getConnection(URL, NAME, PASS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	public static void main(String[] args) {
		System.out.println(getConnection());
	}
}
