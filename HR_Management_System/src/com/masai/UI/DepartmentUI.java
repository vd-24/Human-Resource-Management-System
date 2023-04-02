package com.masai.UI;

import java.util.List;
import java.util.Scanner;

import com.masai.DAO.DepartmentDAO;
import com.masai.DAO.DepartmentDAOImpl;
import com.masai.DTO.Department;
import com.masai.DTO.DepartmentImpl;
import com.masai.Exceptions.RecordNotFoundException;
import com.masai.Exceptions.SomeThingWentWrongException;

public class DepartmentUI {
	static void addNewDepartment(Scanner sc) {
		System.out.println("Enter Department ID :");
		String deptID=sc.next();
		
		System.out.println("Enter Department Name");
		String deptName=sc.next();
		
		Department department = new DepartmentImpl(deptID,deptName);
		
		DepartmentDAO dao = new DepartmentDAOImpl();
		try {
			dao.addNewDepartment(department);
		} catch (SomeThingWentWrongException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	static void viewAllDepartments() {
		DepartmentDAO dao = new DepartmentDAOImpl();
		
			List<Department> list;
			
			try {
				list = dao.getListOfDepartment();
				for(Department i : list) {
					System.out.println(i.getDeptId()+"  -  "+i.getDeptName());
				}
			} catch (RecordNotFoundException | SomeThingWentWrongException e) {

				System.out.println(e.getMessage());
			}
	}
	
	static void updateDepartmentName(Scanner sc) {
		System.out.println("Enter Department ID :");
		String deptID=sc.next();
		
		System.out.println("Enter Department Name");
		String deptName=sc.next();
		
		Department department = new DepartmentImpl(deptID,deptName);
		
		DepartmentDAO dao = new DepartmentDAOImpl();
		try {
			dao.updateDepartmentName(department);
		} catch (SomeThingWentWrongException e) {
			System.out.println(e.getMessage());
		}
	}
}
