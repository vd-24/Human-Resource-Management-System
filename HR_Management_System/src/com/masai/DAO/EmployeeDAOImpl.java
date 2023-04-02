package com.masai.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.masai.DTO.Employee;
import com.masai.DTO.Leave;
import com.masai.DTO.LeaveWithEmpID;
import com.masai.DTO.LeaveWithEmpIDImpl;
import com.masai.Exceptions.RecordNotFoundException;
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
	
	public List<LeaveWithEmpID> showLeaves() throws RecordNotFoundException {
		List<LeaveWithEmpID> list = new ArrayList<>();
		
		Connection con = null;
		try {
			con = DBUtils.getConnectionTodatabase();
			String query = " select k.id,k.employeeId,k.employeename ,d.department_name, k.from_date,k.to_date,k.days,k.status from"
					+ " (select l.id,e.employeeid,e.employeename,l.from_date,l.to_date,l.status,l.days ,e.departmentid from employee e inner join leaves l on e.id=l.employeeid) k "
					+ "inner join department d on k.departmentId=d.id where k.status='pending';";
			
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			if(DBUtils.isResultSetEmpty(rs)) {
				throw new RecordNotFoundException("No Record Found");

			}else {
				while(rs.next()) {	
				list.add(new LeaveWithEmpIDImpl(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5).toLocalDate(), rs.getDate(6).toLocalDate(), rs.getInt(7), rs.getString(8)));
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void approveLeave(int choice, String remark) {
		Connection con = null;
		
		try {
			con = DBUtils.getConnectionTodatabase();
			String query = "UPDATE leaves SET status='Approved',remark='"+remark+"' WHERE id="+choice+"";
			PreparedStatement ps = con.prepareStatement(query);
			
			if(ps.executeUpdate()>0) {
				System.out.println("Leave approved successfully");
				
			}else {
				System.out.println("Can't able to approve the Leave..");
			}
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
//			e1.printStackTrace();
		}
		
		
		try {
			DBUtils.closeConnection(con);
		} catch (SQLException e) {}
	}

	@Override
	public void rejectLeave(int choice, String remark) {
Connection con = null;
		
		try {
			con = DBUtils.getConnectionTodatabase();
			String query = "UPDATE leaves SET status='Rejected',remark='"+remark+"' WHERE id="+choice+"";
			PreparedStatement ps = con.prepareStatement(query);
			
			if(ps.executeUpdate()>0) {
				System.out.println("Leave rejected successfully");
			}else {
				System.out.println("Can't able to reject the Leave..");
			}
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
//			e1.printStackTrace();
		}
		
		
		try {
			DBUtils.closeConnection(con);
		} catch (SQLException e) {}
	}
}
