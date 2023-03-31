package com.masai.DAO;

import com.masai.DTO.Employee;
import com.masai.Exceptions.SomeThingWentWrongException;

public interface EmployeeDAO {

	void addNewEmployee(Employee emp) throws SomeThingWentWrongException;
	public void changeDepartmentOfEmployee(Employee emp) throws SomeThingWentWrongException;
	public void fireAnEmployee(String empID) throws SomeThingWentWrongException;
}
