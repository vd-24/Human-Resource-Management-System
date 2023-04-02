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
import com.masai.DTO.LeaveWithEmpID;
import com.masai.Exceptions.RecordNotFoundException;
import com.masai.Exceptions.SomeThingWentWrongException;

public class HROperationsUI {

	public static void registerNewEmployee(Scanner sc){
		System.out.println("Enter Employee ID : ");
		String employeeID = sc.next();
		
		System.out.println("Enter Employee Name : ");
		String employeeName = sc.next();
		
		System.out.println("Choose Department From Following");
		DepartmentDAO dao = new DepartmentDAOImpl();
		try {
			dao.printDeptOptions();
		} catch (SomeThingWentWrongException | RecordNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		int departmentID = sc.nextInt();
		
	    System.out.println("Enter Username(email)");
		String username = sc.next();
		
		String password=null;
		
		System.out.println("Enter Salary : ");
		int salary = sc.nextInt();
		
		
		LocalDate joiningDate = LocalDate.now();
		
		
		Employee emp = new EmployeeImpl(employeeID,employeeName,departmentID,username,password,salary,joiningDate);
		
		EmployeeDAO empdao = new EmployeeDAOImpl();
	    try {
			empdao.addNewEmployee(emp);
		} catch (SomeThingWentWrongException e) {
			System.out.println(e.getMessage());
		}
	}

	
	public static void changeDepartmentOfEmployee(Scanner sc) {
		System.out.println("Enter Employee ID : ");
		String empID = sc.next();
		
		DepartmentDAO dao = new DepartmentDAOImpl();
		List<Integer> list;
		try {
			list = dao.printDeptOptions();
			System.out.println("Choose Department...");
			
			int departmentID = sc.nextInt();
			while(!list.contains(departmentID)) {
				System.out.println("Please choose correct Option..");
				departmentID=sc.nextInt();
			}
			
			
			Employee emp = new EmployeeImpl(empID,null,departmentID,null,null,0,null);
			
			EmployeeDAO empDao = new EmployeeDAOImpl();
			
				empDao.changeDepartmentOfEmployee(emp);
			
		} catch (SomeThingWentWrongException | RecordNotFoundException e) {
			System.out.println(e.getMessage());
		}

	}

	
	public static void leaveApplication(Scanner sc) {
		EmployeeDAO dao = new EmployeeDAOImpl();
		
		List<LeaveWithEmpID> list;
		try {
			list = dao.showLeaves();
			if(list.isEmpty()) {
				return;
			}
			
			System.out.println("Select Leave ID from Following:");
			for(LeaveWithEmpID i : list) {
				System.out.println("Leave ID : "+i.getId()+"    Employee ID : "+i.getEmployeeid()+"    Employee Name : "+i.getEmployeename()+ "    Department : "+i.getDepartment_name());
			}
			int choice = sc.nextInt();
			boolean flag=false;
			for(LeaveWithEmpID i : list) {
				if(i.getId()==choice) {
					flag=true;
					break;
				}
			}
			

			while(flag==false) {
				System.out.println("Please Enter Correct Input");
				System.out.println("or press 0 to exit");
				choice = sc.nextInt();
				
				if(choice==0) {
					return;
				}
				for(LeaveWithEmpID i : list) {
					if(i.getId()==choice) {
						flag=true;
						break;
					}
				}
			}
			System.out.println("1 : Approve");
			System.out.println("2 : Reject");
			System.out.println("0 : Exit");

		    int c = sc.nextInt();
		  if(c==0) {
			  return;
		  }
		  sc.nextLine();
		  System.out.println("Enter Remark:");
		  String remark = sc.nextLine();
		  if(c==1) {
			  dao.approveLeave(choice,remark);
		  }
		  if(c==2) {

			  dao.rejectLeave(choice,remark);
		  }
			
		} catch (RecordNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}


	public static void fireAnEmployee(Scanner sc){
		System.out.println("Enter Employee ID :");
		String empID = sc.next();
		
		System.out.println("Do you want to fire this employee? please re-confirm...");
		System.out.println("1 : YES");
		System.out.println("2 : NO");
		int fire = sc.nextInt();
		if(fire==1) {
			EmployeeDAO empdao = new EmployeeDAOImpl();
			try {
				empdao.fireAnEmployee(empID);
			} catch (SomeThingWentWrongException e) {
				System.out.println(e.getMessage());
			}
		}else {
			return;
		}
	}

	
	

}
