package com.masai.DAO;

import java.util.List;

import com.masai.DTO.Department;
import com.masai.DTO.Employee;
import com.masai.Exceptions.SomeThingWentWrongException;

public interface DepartmentDAO {
	public void addNewDepartment(Department d) throws SomeThingWentWrongException;
	public List<Department> getListOfDepartment() throws SomeThingWentWrongException;
	public void updateDepartmentName(Department d)  throws SomeThingWentWrongException;
	public List<Integer> printDeptOptions() throws SomeThingWentWrongException;
	
}
