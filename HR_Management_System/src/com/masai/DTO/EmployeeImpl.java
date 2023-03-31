package com.masai.DTO;

import java.time.LocalDate;

public class EmployeeImpl implements Employee{
//	 id               | int         | NO   | PRI | NULL    | auto_increment |
//	 | EmployeeID       | varchar(5)  | NO   | UNI | NULL    |                |
//	 | EmployeeName     | varchar(20) | NO   |     | NULL    |                |
//	 | DepartmentID     | int         | NO   |     | NULL    |                |
//	 | Username         | varchar(15) | NO   | UNI | NULL    |                |
//	 | password         | varchar(10) | NO   |     | 123456  |                |
//	 | salary_per_month | int         | NO   |     | NULL    |                |
//	 | joining_date     | date        | YES  |     | NULL    |                |
//	 | is_deleted       | tinyint     | YES  |     | 1       |                |
	
	String employeeID;
	String employeeName;
	int departmentID;
	String username;
	String password;
	int salary;
	LocalDate joiningDate;
	
	public EmployeeImpl(String employeeID, String employeeName, int departmentID, String username, String password,
			int salary, LocalDate joiningDate) {
		
		this.employeeID = employeeID;
		this.employeeName = employeeName;
		this.departmentID = departmentID;
		this.username = username;
		this.password = password;
		this.salary = salary;
		this.joiningDate = joiningDate;
	}

	@Override
	public String getEmployeeID() {
		return employeeID;
	}

	@Override
	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	@Override
	public String getEmployeeName() {
		return employeeName;
	}

	@Override
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	@Override
	public int getDepartmentID() {
		return departmentID;
	}

	@Override
	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int getSalary() {
		return salary;
	}

	@Override
	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public LocalDate getJoiningDate() {
		return joiningDate;
	}

	@Override
	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}

	
	
}
