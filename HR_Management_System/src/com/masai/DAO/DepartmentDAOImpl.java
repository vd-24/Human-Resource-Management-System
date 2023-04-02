package com.masai.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.masai.DTO.Department;
import com.masai.DTO.DepartmentImpl;
import com.masai.Exceptions.RecordNotFoundException;
import com.masai.Exceptions.SomeThingWentWrongException;

public class DepartmentDAOImpl implements DepartmentDAO{
	
	public void addNewDepartment(Department d) throws SomeThingWentWrongException{
		Connection con = null;
		try {
			con = DBUtils.getConnectionTodatabase();
			String query = "INSERT INTO Department (department_id,department_name) VALUES(?,?)";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, d.getDeptId());
			ps.setString(2, d.getDeptName());
			
			if(ps.executeUpdate()>0) {
				System.out.println("Department Added Successfully");
			}else {
				System.out.println("Not Able To Add Department...");
				System.out.println("Try Again Later..");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new SomeThingWentWrongException("Something went wrong...");
		}
		
		try {
			DBUtils.closeConnection(con);
		} catch (SQLException e) {}
	}
	
	public List<Department> getListOfDepartment() throws SomeThingWentWrongException, RecordNotFoundException {
		
		
		Connection con = null;
		
		try {
			con = DBUtils.getConnectionTodatabase();
			String query = "SELECT department_id,department_name FROM Department WHERE is_deleted=1";
			PreparedStatement ps = con.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			if(DBUtils.isResultSetEmpty(rs)) {
				throw new RecordNotFoundException("No Rocord Found");
			}else {
				List<Department> list = new ArrayList<>();
				while(rs.next()) {
					list.add(new DepartmentImpl(rs.getString(1),rs.getString(2)));
				}
				DBUtils.closeConnection(con);
				return list;
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new SomeThingWentWrongException("Something went wrong");
		}
		
		
		
}

	
	public void updateDepartmentName(Department d)  throws SomeThingWentWrongException{
		
			Connection con = null;
			try {
				con = DBUtils.getConnectionTodatabase();
				String query = "UPDATE Department SET department_name =? WHERE department_id=? AND is_deleted=1";
				
				PreparedStatement ps = con.prepareStatement(query);
				
				ps.setString(1, d.getDeptName());
				ps.setString(2, d.getDeptId());
				
				if(ps.executeUpdate()>0) {
					System.out.println("Department Name Updated Successfully");
				}else {
					System.out.println("Not Able To Update Department Name...");
					System.out.println("Try Again Later..");
				}
				
			} catch (ClassNotFoundException | SQLException e) {
				throw new SomeThingWentWrongException("Something went wrong...");
			}
			
			try {
				DBUtils.closeConnection(con);
			} catch (SQLException e) {}
		}
	
	public List<Integer> printDeptOptions() throws SomeThingWentWrongException, RecordNotFoundException {
		Connection con = null;
		List<Integer> list = new ArrayList<>();
		try {
			con = DBUtils.getConnectionTodatabase();
			String query = "SELECT id,department_name FROM Department WHERE is_deleted=1";
			PreparedStatement ps = con.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			if(DBUtils.isResultSetEmpty(rs)) {
				throw new RecordNotFoundException("No Record Found");
			}else {
			
				while(rs.next()) {
					System.out.println(""+rs.getInt(1)+" : "+rs.getString(2)+"");
					list.add(rs.getInt(1));
				}
				
				DBUtils.closeConnection(con);
				
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new SomeThingWentWrongException("Something went wrong");
		}
		return list;
	}
	
	
	}

