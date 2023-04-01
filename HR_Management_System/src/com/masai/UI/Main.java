package com.masai.UI;

import java.util.Scanner;

import com.masai.Exceptions.SomeThingWentWrongException;

public class Main {

	private static void adminLogin(Scanner sc) throws SomeThingWentWrongException {
		
		System.out.println("Enter Username : ");
		String username = sc.next();
		
		System.out.println("Enter Password : ");
		String password = sc.next();
		
		if(username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {
			System.out.println("Log In Successfull");
			adminMenu(sc);
		}else {
			System.out.println("Incorrect Username or Password");
		}
		
	}
	
	private static void adminMenu(Scanner sc) throws SomeThingWentWrongException {
		int choice=0;
		
		do {
			System.out.println();
			System.out.println("Enter Your Choice...");
			displayAdminOptions();
			
			choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				DepartmentUI.addNewDepartment(sc);
				break;
				
			case 2:
				DepartmentUI.viewAllDepartments();
				break;
				
			case 3:
				DepartmentUI.updateDepartmentName(sc);
				break;
				
			case 4:
				HROperationsUI.registerNewEmployee(sc);
				break;
				
			case 5:
				HROperationsUI.changeDepartmentOfEmployee(sc);
				break;
				
			case 6:
				HROperationsUI.leaveApplication();
				break;
				
			case 7:
				HROperationsUI.fireAnEmployee(sc);
				break;
				
			case 0:
				System.out.println("You are logged out...");
				break;
				
			default:
				System.out.println("Enter Valid Selection");
				break;
			}
			
		}while(choice!=0);
	}
	
    private static void  displayAdminOptions() {

    	System.out.println("1 : Add New Department");
    	System.out.println("2 : View All Departments");
    	System.out.println("3 : Update Department Name");
    	System.out.println("4 : Register New Employee");
    	System.out.println("5 : Change Department Of Employee");
    	System.out.println("6 : Leave Applications");
    	System.out.println("7 : Fire An Employee");
    	System.out.println("0 : Log Out");

    }
	
    private static void employeeLogin(Scanner sc) throws SomeThingWentWrongException {
    	if(EmployeeUI.userLogIn(sc)==false) { 
    		return;
    	}
    	System.out.println("Log In Successfull");
    	int choice=0;
    	do {
    		displayEmployeeOption();
    		choice = sc.nextInt();
    		
    		switch(choice) {
    		case 1:
    			EmployeeUI.updateAccountDetails(sc);
    			break;
    			
    		case 2:
    			EmployeeUI.applyForLeave(sc);
    			break;
    			
    		case 3:
//    			EmployeeUI.leavesHistory();
    			break;
    			
    		case 4:
   			EmployeeUI.leavesHistory();
    			break;
    			
    		case 5:
//    			See Total Salary
    			break;
    			
    		case 6:
    			EmployeeUI.deleteAccount();
    			EmployeeUI.logout();
    			break;
    			
    		case 0:
    			EmployeeUI.logout();
    			break;
    			
    		default:
    			System.out.println("Enter valid choice");
    			break;
    			
    		}
    		
    		
    	}while(choice!=0);
    
    }
    private static void displayEmployeeOption() {
    	System.out.println("1 : Update Account Details");
    	System.out.println("2 : Apply For Leave");
    	System.out.println("3 : See status of leave");
    	System.out.println("4 : See Leaves History");
    	System.out.println("5 : See Salary Details");
    	System.out.println("6 : Delete Account");
    	System.out.println("0 : Log Out");

    }
    
	public static void main(String[] args) throws SomeThingWentWrongException {
		Scanner sc = new Scanner(System.in);
		System.out.println("WELCOME......");
		int choice =0;
		
		do {
			System.out.println();
			System.out.println("Enter Your Choice.");
			System.out.println("1 : Admin Login");
			System.out.println("2 : Employee Login");
			System.out.println("0 : Exit");
			
			choice = sc.nextInt();
			
			switch(choice) {
			
			case 1:
				adminLogin(sc);
				break;
				
			case 2:
				employeeLogin(sc);
				break;
				
			case 0:
				System.out.println("Thank You...");
				break;
				
			default:
				System.out.println("Enter Correct Choice");
				break;
			}
			
		}while(choice!=0);
		
		sc.close();
	}

	

}
