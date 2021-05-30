package com.IsteMysql.Util;

import java.sql.*;

public class VeritabaniUtil {
	
	static Connection conn=null;
	public static Connection Baglan() {
		try {
			//conn=DriverManager.getConnection("jdbc:mysql://ServerIP/db_ismi", "kullanici", "sifre");
			
			conn=DriverManager.getConnection("jdbc:mysql://localhost/db", "phpmyadmin", "123456");
			return conn;
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
			return null;
			// TODO: handle exception
		}
	}
	

}
