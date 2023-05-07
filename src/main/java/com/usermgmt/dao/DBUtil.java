package com.usermgmt.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {

	public static Connection connect() {
		Connection conn = null;
		try {
			String url = "jdbc:mysql://localhost:3306/user_mgmt_db";
			String username = "root";
			String password = "akash13sql";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connected successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
