package com.masai.DTO;

import java.time.LocalDate;

public class LeaveImpl implements Leave{
/*
 *  EmployeeID | int         | NO   |     | NULL    |                |
| from_date  | date        | NO   |     | NULL    |                |
| to_date    | date        | NO   |     | NULL    |                |
| status     | varchar(10) | YES  |     | Pending |                |
| days       | int         | YES  |     | NULL    |                |
| remark
 */
	
	int empID;
	LocalDate from;
	LocalDate to;
	String status;
	int days;
	String remark;
	
	public LeaveImpl(int empID, LocalDate from, LocalDate to, String status, int days, String remark) {
		this.empID = empID;
		this.from = from;
		this.to = to;
		this.status = status;
		this.days = days;
		this.remark = remark;
	}

	@Override
	public int getEmpID() {
		return empID;
	}

	@Override
	public void setEmpID(int empID) {
		this.empID = empID;
	}

	@Override
	public LocalDate getFrom() {
		return from;
	}

	@Override
	public void setFrom(LocalDate from) {
		this.from = from;
	}

	@Override
	public LocalDate getTo() {
		return to;
	}

	@Override
	public void setTo(LocalDate to) {
		this.to = to;
	}

	@Override
	public String getStatus() {
		return status;
	}

	@Override
	public void setStatus(String status) {
		this.status = status;
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
	public String getRemark() {
		return remark;
	}

	@Override
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
