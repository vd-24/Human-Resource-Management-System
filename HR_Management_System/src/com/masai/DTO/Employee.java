package com.masai.DTO;

import java.time.LocalDate;

public interface Employee {
	public String getEmployeeID();

	public void setEmployeeID(String employeeID);

	public String getEmployeeName();

	public void setEmployeeName(String employeeName);

	public int getDepartmentID();

	public void setDepartmentID(int departmentID);

	public String getUsername();

	public void setUsername(String username);

	public String getPassword();

	public void setPassword(String password);

	public int getSalary();

	public void setSalary(int salary);

	public LocalDate getJoiningDate();

	public void setJoiningDate(LocalDate joiningDate);
}
