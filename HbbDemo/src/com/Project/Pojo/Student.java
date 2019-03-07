package com.Project.Pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Student 
{
		@Id
		private int roolno;
		private String sname;
		private long salary;
		
		@OneToOne
		private Laptop laptop;
		
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
		public Laptop getLaptop() {
			return laptop;
		}
		
		public void setLaptop(Laptop laptop) {
			this.laptop = laptop;
		}
		public void setSalary(long salary) {
			this.salary = salary;
		}
}
