package com.masai.DTO;

import java.time.LocalDate;

public interface LeaveWithEmpID {
	public int getId();
	public void setId(int id);
	public String getEmployeeid();
	public void setEmployeeid(String employeeid);
	public String getEmployeename();
	public void setEmployeename(String employeename);
	public String getDepartment_name();
	public void setDepartment_name(String department_name);
	public LocalDate getFrom_date();
	public void setFrom_date(LocalDate from_date);
	public LocalDate getTo_date();
	public void setTo_date(LocalDate to_date);
	public int getDays();
	public void setDays(int days);
	public String getStatus();
	public void setStatus(String status);
	
}
