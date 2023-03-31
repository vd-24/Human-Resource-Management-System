package com.masai.UI;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

import com.masai.DAO.EmployeeOperationDAO;
import com.masai.DAO.EmployeeOperationDAOImpl;
import com.masai.DAO.UserLoggedIn;
import com.masai.DTO.EmployeeImpl;
import com.masai.DTO.Leave;
import com.masai.DTO.LeaveImpl;
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
	
	public static void deleteAccount() throws SomeThingWentWrongException {
		EmployeeOperationDAO dao = new EmployeeOperationDAOImpl();
		dao.deleteAccount();
	}
	
	public static void updateAccountDetails(Scanner sc) throws SomeThingWentWrongException {
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
				dao.updateEmployeeName(emp);
				break;
				
			case 2:
				System.out.println("Enter New Username :");
				String username=sc.next();
				emp.setUsername(username);
				dao.updateEmployeeUsername(emp);
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
				
				dao.updatePassword(emp);
				break;
				
			case 0:
				break;
				
			default:
				System.out.println("Enter Correct Choice");
				break;
			}
			
		}while(choice!=0);
		
		
		
		
		
	}

	public static void applyForLeave(Scanner sc) throws SomeThingWentWrongException {
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
		Leave leave = new LeaveImpl(empid,from,to,null,days,null);

		EmployeeOperationDAO dao = new EmployeeOperationDAOImpl();
		
		dao.applyForLeave(leave);

		
	}
	
}
