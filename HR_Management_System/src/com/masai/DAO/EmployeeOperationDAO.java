package com.masai.DAO;

import com.masai.DTO.Employee;
import com.masai.DTO.Leave;
import com.masai.Exceptions.SomeThingWentWrongException;

public interface EmployeeOperationDAO {
	public void userLogIn(String username , String password) throws SomeThingWentWrongException;
	public void logOut();
	public void deleteAccount() throws SomeThingWentWrongException;
	public void updateEmployeeName(Employee emp) throws SomeThingWentWrongException;
	public void updatePassword(Employee emp) throws SomeThingWentWrongException;
	public void updateEmployeeUsername(Employee emp) throws SomeThingWentWrongException;
	public void applyForLeave(Leave leave) throws SomeThingWentWrongException;
}
