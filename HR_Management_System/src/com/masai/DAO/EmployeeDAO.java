package com.masai.DAO;

import java.util.List;

import com.masai.DTO.Employee;
import com.masai.DTO.LeaveWithEmpID;
import com.masai.Exceptions.RecordNotFoundException;
import com.masai.Exceptions.SomeThingWentWrongException;

public interface EmployeeDAO {

	void addNewEmployee(Employee emp) throws SomeThingWentWrongException;
	public void changeDepartmentOfEmployee(Employee emp) throws SomeThingWentWrongException;
	public void fireAnEmployee(String empID) throws SomeThingWentWrongException;
	public List<LeaveWithEmpID> showLeaves() throws RecordNotFoundException;
	void approveLeave(int choice, String remark);
	void rejectLeave(int choice, String remark);
}
