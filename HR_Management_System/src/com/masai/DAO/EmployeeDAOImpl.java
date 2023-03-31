package com.masai.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import com.masai.DTO.Employee;
import com.masai.Exceptions.SomeThingWentWrongException;

public class EmployeeDAOImpl implements EmployeeDAO{
	public void addNewEmployee(Employee emp) throws SomeThingWentWrongException {
		Connection con = null;
		String query = "INSERT INTO Employee (EmployeeID,Employeename,departmentid,username,salary_per_month,joining_date)"
				+ "VALUES(?,?,?,?,?,?)";
		try {
			con = DBUtils.getConnectionTodatabase();
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, emp.getEmployeeID());
			ps.setString(2, emp.getEmployeeName());
			ps.setInt(3, emp.getDepartmentID());
			ps.setString(4, emp.getUsername());
			ps.setInt(5, emp.getSalary());
			ps.setDate(6, Date.valueOf(emp.getJoiningDate()));
			
			if(ps.executeUpdate()>0) {
				System.out.println("Employee Added Successfully....");
			}else {
				System.out.println("Not able to add employee...    Try Again Later...");
			}
			
		} catch (SQLException | ClassNotFoundException e) {
			throw new SomeThingWentWrongException("Something went wrong....");
		}
		try {
			DBUtils.closeConnection(con);
		} catch (SQLException e) {}
	}
	
	public void changeDepartmentOfEmployee(Employee emp) throws SomeThingWentWrongException {
		Connection con = null;
		
		try {
			con = DBUtils.getConnectionTodatabase();
			String query = "UPDATE Employee SET departmentid=? WHERE EmployeeID=?";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setInt(1, emp.getDepartmentID());
			ps.setString(2, emp.getEmployeeID());
			
			if(ps.executeUpdate()>0) {
				System.out.println("Employee's Department Is Changed...");
			}else {
				System.out.println("Not able to change the department... Try Again...");
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new SomeThingWentWrongException("Something went wrong...");
		}
		
		try {
			DBUtils.closeConnection(con);
		} catch (SQLException e) {}
		
	}

	@Override
	public void fireAnEmployee(String empID) throws SomeThingWentWrongException{
		Connection con = null;
		
		try {
			con = DBUtils.getConnectionTodatabase();
			PreparedStatement ps = con.prepareStatement("UPDATE Employee SET is_deleted=0 WHERE employeeID = '"+empID+"'");
			if(ps.executeUpdate()>0) {
				System.out.println("Employee is fired...");
			}else {
				System.out.println("Not able to complete this task... Try Again");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new SomeThingWentWrongException("Something went wrong exception..");
		}
		
		try {
			DBUtils.closeConnection(con);
		} catch (SQLException e) {
			
		}
	}
}
