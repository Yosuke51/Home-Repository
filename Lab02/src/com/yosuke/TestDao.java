package com.yosuke;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestDao {

	public static void main(String[] args){
		      TestDao dao = new TestDao();
		      
			try {
				dao.connection();
				System.out.println(dao.login(1002,"engineer"));
				
				System.out.println("==========================");
				
				System.out.println(dao.changepw(1003, "boss", "manager"));
				
				if(dao.changepw(1003, "boss", "manager") == true)
				{
				System.out.println("密碼修改成功");}
				else{
				System.out.println("帳號密碼錯誤 ");
				}
				
				System.out.println("==========================");
				
				
				List<DAO> alllist = dao.selectall();
				for(DAO si : alllist){
					System.out.println(si.getEmpno() + " : " + si.getEname());
				}
				
				System.out.println("==========================");
				
				DAO a = new DAO();
				a.setEmpno(1009);
				a.setEname("AOA");
				a.setHiredate(java.sql.Date.valueOf("2015-06-09"));
				a.setSalary(109472);
				a.setDeptno(200);
				a.setTitle("ART");
				System.out.println(dao.insert(a));
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	
	private static final String login = "SELECT * FROM employee where empno = ? and title = ?";
	private static final String selectALL = "SELECT * FROM employee";
	private static final String insert = "INSERT INTO employee Values (?,?,?,?,?,?)";
	private static final String changepw = "UPDATE employee SET title = ? where empno = ?";
	
	
	Connection conn = null;
	
	public void connection() throws SQLException{
		String url = "jdbc:sqlserver://10.211.55.5:1433;databaseName=jdbc;user=sa;password=passw0rd";
		conn = DriverManager.getConnection(url);
	}
	
	public Boolean login(int id, String password) throws SQLException{
		Boolean check = false ;
		PreparedStatement ps =conn.prepareStatement(login);
		ps.setInt(1, id);
		ps.setString(2, password);
		check = ps.execute();
		
		return check;
	}
	
	public Boolean changepw(int id, String password, String oldpassword) throws SQLException{
		Boolean result = false;
		
		PreparedStatement ps = conn.prepareStatement(login);
		ps.setInt(1, id);
		ps.setString(2, oldpassword);
		Boolean check = ps.execute();
		
		int i =0;
		if (check == true){
			ps = conn.prepareStatement(changepw);
			ps.setString(1, password);
			ps.setInt(2, id);
			i = ps.executeUpdate();
			if(i==1){
				return result = true;
			}
		}
		
		return result;
	}
	
	public List<DAO> selectall() throws SQLException{
		List<DAO> li = new  ArrayList<>(); 
		DAO dao = null;
		
		PreparedStatement ps = conn.prepareStatement(selectALL);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			dao = new DAO();
			dao.setEmpno(rs.getInt(1));
			dao.setEname(rs.getString(2));
			dao.setHiredate(rs.getDate(3));
			dao.setSalary(rs.getInt(4));
			dao.setDeptno(rs.getInt(5));
			dao.setTitle(rs.getString(6));
			li.add(dao);
		}
		return li;
	}
	
	public DAO insert(DAO bean) throws SQLException{
		DAO dao = new DAO();
		
		PreparedStatement ps = conn.prepareStatement(insert);
		
		ps.setInt(1, bean.getEmpno());
		ps.setString(2, bean.getEname());
		ps.setDate(3, bean.getHiredate());
		ps.setInt(4, bean.getSalary());
		ps.setInt(5, bean.getDeptno());
		ps.setString(6, bean.getTitle());
		ps.executeUpdate();
		
		dao.setDeptno(bean.getEmpno());
		dao.setEname(bean.getEname());
		dao.setHiredate(bean.getHiredate());
		dao.setSalary(bean.getSalary());
		dao.setDeptno(bean.getDeptno());
		dao.setTitle(bean.getTitle());
		
		return dao;
	}

}
