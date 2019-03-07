package com.Project.Pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student 
{
		@Id
		private int roolno;
		private String sname;
		private long salary;
		
		public int getRoolno() {
			return roolno;
		}
		public void setRoolno(int roolno) {
			this.roolno = roolno;
		}
		public String getSname() {
			return sname;
		}
		public void setSname(String sname) {
			this.sname = sname;
		}
		public long getSalary() {
			return salary;
		}
		public void setSalary(long salary) {
			this.salary = salary;
		}
	
}
