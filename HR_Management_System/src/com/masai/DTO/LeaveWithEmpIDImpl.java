package com.masai.DTO;

import java.time.LocalDate;

public class LeaveWithEmpIDImpl implements LeaveWithEmpID{
	private int id;
	private String employeeid;
	private String employeename;
	private String department_name;
	private LocalDate from_date;
	private LocalDate to_date;
	private int days;
	private String status;
	
	public LeaveWithEmpIDImpl(int id, String employeeid, String employeename, String department_name,
			LocalDate from_date, LocalDate to_date, int days, String status) {
		this.id = id;
		this.employeeid = employeeid;
		this.employeename = employeename;
		this.department_name = department_name;
		this.from_date = from_date;
		this.to_date = to_date;
		this.days = days;
		this.status = status;
	}
	
	
	@Override
	public int getId() {
		return id;
	}
	
	@Override
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String getEmployeeid() {
		return employeeid;
	}
	
	@Override
	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}
	
	@Override
	public String getEmployeename() {
		return employeename;
	}
	
	@Override
	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}
	
	@Override
	public String getDepartment_name() {
		return department_name;
	}
	
	@Override
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	
	@Override
	public LocalDate getFrom_date() {
		return from_date;
	}
	
	@Override
	public void setFrom_date(LocalDate from_date) {
		this.from_date = from_date;
	}
	
	@Override
	public LocalDate getTo_date() {
		return to_date;
	}
	
	@Override
	public void setTo_date(LocalDate to_date) {
		this.to_date = to_date;
	}
	
	@Override
	public int getDays() {
		return days;
	}
	
	@Override
	public void setDays(int days) {
		this.days = days;
	}
	
	@Override
	public String getStatus() {
		return status;
	}
	
	@Override
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
}
