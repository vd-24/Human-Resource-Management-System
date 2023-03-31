package com.masai.UI;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.masai.DAO.DepartmentDAO;
import com.masai.DAO.DepartmentDAOImpl;
import com.masai.DAO.EmployeeDAO;
import com.masai.DAO.EmployeeDAOImpl;
import com.masai.DTO.Employee;
import com.masai.DTO.EmployeeImpl;
import com.masai.Exceptions.SomeThingWentWrongException;

public class HROperationsUI {

	public static void registerNewEmployee(Scanner sc) throws SomeThingWentWrongException {
		System.out.println("Enter Employee ID : ");
		String employeeID = sc.next();
		
		System.out.println("Enter Employee Name : ");
		String employeeName = sc.next();
		
		System.out.println("Choose Department From Following");
		DepartmentDAO dao = new DepartmentDAOImpl();
		dao.printDeptOptions();
		
		int departmentID = sc.nextInt();
		
	    System.out.println("Enter Username(email)");
		String username = sc.next();
		
		String password=null;
		
		System.out.println("Enter Salary : ");
		int salary = sc.nextInt();
		
		
		LocalDate joiningDate = LocalDate.now();
		
		
		Employee emp = new EmployeeImpl(employeeID,employeeName,departmentID,username,password,salary,joiningDate);
		
		EmployeeDAO empdao = new EmployeeDAOImpl();
	    empdao.addNewEmployee(emp);
	}

	
	public static void changeDepartmentOfEmployee(Scanner sc) throws SomeThingWentWrongException {
		System.out.println("Enter Employee ID : ");
		String empID = sc.next();
		
		DepartmentDAO dao = new DepartmentDAOImpl();
		List<Integer> list = dao.printDeptOptions();
		
		System.out.println("Choose Department...");
		
		int departmentID = sc.nextInt();
		while(!list.contains(departmentID)) {
			System.out.println("Please choose correct Option..");
			departmentID=sc.nextInt();
		}
		
		
		Employee emp = new EmployeeImpl(empID,null,departmentID,null,null,0,null);
		
		EmployeeDAO empDao = new EmployeeDAOImpl();
		empDao.changeDepartmentOfEmployee(emp);
		
	}

	
	public static void leaveApplication() {
		
	}


	public static void fireAnEmployee(Scanner sc) throws SomeThingWentWrongException {
		System.out.println("Enter Employee ID :");
		String empID = sc.next();
		
		System.out.println("Do you want to fire this employee? please re-confirm...");
		System.out.println("1 : YES");
		System.out.println("2 : NO");
		int fire = sc.nextInt();
		if(fire==1) {
			EmployeeDAO empdao = new EmployeeDAOImpl();
			empdao.fireAnEmployee(empID);
		}else {
			return;
		}
	}

	
	

}
