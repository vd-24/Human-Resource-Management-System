package com.masai.DTO;

import java.time.LocalDate;

public interface Leave {
	public int getEmpID();

	public void setEmpID(int empID);

	public LocalDate getFrom();

	public void setFrom(LocalDate from);

	public LocalDate getTo();

	public void setTo(LocalDate to);

	public String getStatus();

	public void setStatus(String status);

	public int getDays();

	public void setDays(int days);

	public String getRemark();

	public void setRemark(String remark);


}
