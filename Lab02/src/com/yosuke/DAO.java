package com.yosuke;

public class DAO {
	
		private int empno ;
		private String ename;
		private java.sql.Date hiredate;
		private int salary;
		private int deptno;
		private String title;
		
		
		
		
		@Override
		public String toString() {
		
			return ename +" : " + hiredate +" : " + salary +" : " + deptno +" : " + title;
		}
		
		public int getEmpno() {
			return empno;
		}
		public void setEmpno(int empno) {
			this.empno = empno;
		}
		public String getEname() {
			return ename;
		}
		public void setEname(String ename) {
			this.ename = ename;
		}
		public java.sql.Date getHiredate() {
			return hiredate;
		}
		public void setHiredate(java.sql.Date hiredate) {
			this.hiredate = hiredate;
		}
		public int getSalary() {
			return salary;
		}
		public void setSalary(int salary) {
			this.salary = salary;
		}
		public int getDeptno() {
			return deptno;
		}
		public void setDeptno(int deptno) {
			this.deptno = deptno;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		
		
}
