package com.yosuke;

import java.sql.*;

public class MetaData {

	public static void main(String[] args) {
		String url = "jdbc:sqlserver://10.211.55.5:1433;databaseName=jdbc;user=sa;password=passw0rd";
		String sql = "SELECT * FROM employee";
		
		try(Connection conn = DriverManager.getConnection(url);) {
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			ResultSetMetaData rsmd = rs.getMetaData();
			
			
			int number = rsmd.getColumnCount();
			System.out.println(number);
			
			for(int i = 1; i<=number;i++){
				System.out.print(rsmd.getColumnName(i)+ "  ");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
