package com.masai.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import com.masai.DTO.Employee;
import com.masai.DTO.Leave;
import com.masai.Exceptions.SomeThingWentWrongException;

public class EmployeeOperationDAOImpl implements EmployeeOperationDAO{
	public void userLogIn(String username , String password) throws SomeThingWentWrongException {
		Connection con = null;
				
				try {
					con = DBUtils.getConnectionTodatabase();
					String query = "SELECT ID from Employee WHERE username='"+username+"' AND password='"+password+"' AND is_deleted=1";
					PreparedStatement ps = con.prepareStatement(query);
					
					ResultSet rs = ps.executeQuery();
					
					
					if(DBUtils.isResultSetEmpty(rs)) {
						throw new SomeThingWentWrongException("Invalid Credentials...");
					}else {
						rs.next();
						int empID = rs.getInt(1);
						UserLoggedIn.loggedInUser=empID;
					}
					
				} catch (ClassNotFoundException | SQLException e) {
					throw new SomeThingWentWrongException("Something went wrong");
				}
				try {
					DBUtils.closeConnection(con);
				} catch (SQLException e) {	}
				
	
		
	}
	
	public void logOut() {
		UserLoggedIn.loggedInUser=0;
	}

	@Override
	public void deleteAccount() throws SomeThingWentWrongException {
		Connection con = null;
		try {
			con=DBUtils.getConnectionTodatabase();
			String query = "UPDATE employee SET is_deleted=0 WHERE ID = "+UserLoggedIn.loggedInUser+"";
			PreparedStatement ps = con.prepareStatement(query);
			
			if(ps.executeUpdate()>0) {
				System.out.println("Account Deleted Successfully");
			}
			else {
				System.out.println("Not able to delete account");
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new SomeThingWentWrongException("Something went wrong..");
		}
		try {
			DBUtils.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateEmployeeName(Employee emp) throws SomeThingWentWrongException {
		Connection con = null;
		try {
			con=DBUtils.getConnectionTodatabase();
			String query = "UPDATE employee SET EmployeeName='"+emp.getEmployeeName()+"' WHERE ID = "+UserLoggedIn.loggedInUser+"";
			PreparedStatement ps = con.prepareStatement(query);
			
			if(ps.executeUpdate()>0) {
				System.out.println("Name Updated Successfully");
			}
			else {
				System.out.println("Not able to update name");
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new SomeThingWentWrongException("Something went wrong..");
		}
		try {
			DBUtils.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updatePassword(Employee emp) throws SomeThingWentWrongException {
		Connection con = null;
		try {
			con=DBUtils.getConnectionTodatabase();
			String query = "UPDATE employee SET password='"+emp.getPassword()+"' WHERE ID = "+UserLoggedIn.loggedInUser+"";
			PreparedStatement ps = con.prepareStatement(query);
			
			if(ps.executeUpdate()>0) {
				System.out.println("Password Updated Successfully");
			}
			else {
				System.out.println("Not able to update password");
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new SomeThingWentWrongException("Something went wrong..");
		}
		try {
			DBUtils.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateEmployeeUsername(Employee emp) throws SomeThingWentWrongException{
		Connection con = null;
		try {
			con=DBUtils.getConnectionTodatabase();
			String query = "UPDATE employee SET username='"+emp.getUsername()+"' WHERE ID = "+UserLoggedIn.loggedInUser+"";
			PreparedStatement ps = con.prepareStatement(query);
			
			if(ps.executeUpdate()>0) {
				System.out.println("Username Updated Successfully");
			}
			else {
				System.out.println("Not able to update Username");
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new SomeThingWentWrongException("Something went wrong..");
		}
		try {
			DBUtils.closeConnection(con);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void applyForLeave(Leave leave) throws SomeThingWentWrongException {
		Connection con = null;
//		int empID;
//		LocalDate from;
//		LocalDate to;
//		String status;
//		int days;
//		String remark;
		try {
			con = DBUtils.getConnectionTodatabase();
			
			String query = "INSERT INTO leaves (EmployeeID,from_date,to_date,status,days,remark) VALUES (?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setInt(1, leave.getEmpID());
			ps.setDate(2,Date.valueOf(leave.getFrom()));
			ps.setDate(3,Date.valueOf(leave.getTo()));
			ps.setString(4, null);
			ps.setInt(5,leave.getDays());
			ps.setString(6, null);
			
			if(ps.executeUpdate()>0) {
				System.out.println("Applied for leave Successfully");
			}else {
				System.out.println("Not able to apply for the leave.");
			}
			
			  
		} catch (ClassNotFoundException | SQLException e) {
			throw new SomeThingWentWrongException("Something went wrong...");
		}
		
		try {
			DBUtils.closeConnection(con);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
