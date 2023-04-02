package com.masai.UI;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Scanner;

import com.masai.DAO.EmployeeDAO;
import com.masai.DAO.EmployeeDAOImpl;
import com.masai.DAO.EmployeeOperationDAO;
import com.masai.DAO.EmployeeOperationDAOImpl;
import com.masai.DAO.UserLoggedIn;
import com.masai.DTO.EmployeeImpl;
import com.masai.DTO.Leave;
import com.masai.DTO.LeaveImpl;
import com.masai.Exceptions.RecordNotFoundException;
import com.masai.Exceptions.SomeThingWentWrongException;

public class EmployeeUI {
	public static boolean userLogIn(Scanner sc) {

    	System.out.println("Enter Username(email)");
    	String username = sc.next();
    	
    	System.out.println("Enter password");
    	String password = sc.next();;
    	
    	EmployeeOperationDAO dao = new EmployeeOperationDAOImpl();
    	try {
    		dao.userLogIn(username, password);
    	}catch(Exception ex) {
    		System.out.println(ex.getMessage());
    		return false;
    	}
    	
		return true;
	}
	
	public static void logout() {
		EmployeeOperationDAO dao = new EmployeeOperationDAOImpl();
		dao.logOut();
	}
	
	public static void deleteAccount(){
		EmployeeOperationDAO dao = new EmployeeOperationDAOImpl();
		try {
			dao.deleteAccount();
		} catch (SomeThingWentWrongException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void updateAccountDetails(Scanner sc){
		int choice  = 0;
		EmployeeImpl emp = new EmployeeImpl(null, null, 0, null, null, 0, null);
		EmployeeOperationDAO dao = new EmployeeOperationDAOImpl();
		do {
			System.out.println("1 : Update Employee Name ");
			System.out.println("2 : Update Username");
			System.out.println("3 : Update Password");
			System.out.println("0 : Exit");
			
			choice  = sc.nextInt();
			switch(choice) {
			
			case 1:
				System.out.println("Enter New Name :");
				String name = sc.next();
				emp.setEmployeeName(name);
				try {
					dao.updateEmployeeName(emp);
				} catch (SomeThingWentWrongException e) {
					System.out.println(e.getMessage());
				}
				break;
				
			case 2:
				System.out.println("Enter New Username :");
				String username=sc.next();
				emp.setUsername(username);
				try {
					dao.updateEmployeeUsername(emp);
				} catch (SomeThingWentWrongException e) {
					System.out.println(e.getMessage());
				}
				break;
				
			case 3:
				System.out.println("Enter New Password :");
				String newPass=sc.next();
				
				System.out.println("Confirm New Password :");
				String newPassConfirm = sc.next();
				
				if(!newPass.equals(newPassConfirm)) {
					System.out.println("Password doesn't match");
					break;
				}
				emp.setPassword(newPassConfirm);
				
				try {
					dao.updatePassword(emp);
				} catch (SomeThingWentWrongException e) {
					System.out.println(e.getMessage());
				}
				break;
				
			case 0:
				break;
				
			default:
				System.out.println("Enter Correct Choice");
				break;
			}
			
		}while(choice!=0);
		
		
		
		
		
	}

	public static void applyForLeave(Scanner sc){
		int empid = UserLoggedIn.loggedInUser;
		System.out.println("Enter Starting Date (YYYY-MM-DD) :");
		LocalDate from = LocalDate.parse(sc.next());
		
		System.out.println("Enter Ending Date (YYYY-MM-DD) :");
		LocalDate to = LocalDate.parse(sc.next());
		
		int days = (int) ChronoUnit.DAYS.between(from, to);
		while(days<0) {
			System.out.println("Please enter valid dates");
			System.out.println("Enter Starting Date (YYYY-MM-DD) :");
			from = LocalDate.parse(sc.next());
			
			System.out.println("Enter Ending Date (YYYY-MM-DD) :");
			 to = LocalDate.parse(sc.next());
			
			 days = (int) ChronoUnit.DAYS.between(from, to);
		}
		Leave leave = new LeaveImpl(empid,from,to,"Pending",days,null);

		EmployeeOperationDAO dao = new EmployeeOperationDAOImpl();
		
		try {
			dao.applyForLeave(leave);
		} catch (SomeThingWentWrongException e) {
			System.out.println(e.getMessage());
		}

		
	}
	
	
	public static void leavesHistory() {
		EmployeeOperationDAO dao = new EmployeeOperationDAOImpl();
		
		try {
			List<Leave> list = dao.getLeavesHistory();
			
			for(Leave i : list) {
				System.out.println();
				System.out.println("Date From : "+i.getFrom());
				System.out.println("Date To : "+i.getTo());
				System.out.println("No. of days : "+i.getDays());
				System.out.println("Status :"+i.getStatus());
				System.out.println("Remark :"+i.getRemark());
				
				System.out.println();
				System.out.println("=======================================");
			}
			
			
		} catch (SomeThingWentWrongException | RecordNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		
		
	}

	public static void showSalary() {
		EmployeeOperationDAO dao = new EmployeeOperationDAOImpl();
		
		int salary;
		try {
			salary = dao.showSalaryPerMonth();
			
			int annualSalary = salary*12;
			System.out.println();
			System.out.println("Your Total Monthly Salary Is: "+salary);
			
			System.out.println("Your Total Annual Salary Is: "+ annualSalary);
			System.out.println();
		} catch (RecordNotFoundException e) {
			System.out.println(e.getMessage());
		}
	
	}

	public static void leavesStatus() {
	  EmployeeOperationDAO dao = new EmployeeOperationDAOImpl();
		Leave leave;
		try {
			leave = dao.getLeaveStatus();
			System.out.println("-----------------------------------");
			System.out.println("Start Date : "+leave.getFrom());
			System.out.println("End Date   : "+leave.getTo());
			System.out.println("No.of days : "+leave.getDays());
			System.out.println("Status     : "+leave.getStatus());
			System.out.println("Remark     : "+leave.getRemark());
			System.out.println("------------------------------------");
		} catch (RecordNotFoundException e) {

			System.out.println(e.getMessage());
		}
	
	}
	
}
