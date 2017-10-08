package util;

import java.sql.*;

public class JdbcDriver {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost/test";
			String user = "root";
			String password = "";

			System.out.println("URL      :" + url);
			System.out.println("USER     :" + user);
			System.out.println("PASSWORD :" + password);
			
			System.out.println("データベースに接続します...");
			Connection conn = DriverManager.getConnection(url, user, password);
			
			System.out.println("データベースと接続しました");
			
			conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
