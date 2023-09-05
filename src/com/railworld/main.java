package com.railworld;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		employeeDao dao = new employeeDaoImpl(); 
		// TODO Auto-generated method stub
		System.out.println("Welcome to the Employee Management System!");
		Scanner sc = new Scanner(System.in);
		
		do {
			
			System.out.println("1. Add the Employee\n" +
			"2. Show All the Employee\n" +
			"3. Show the Employee using Id\n" +
			"4. Update the Employee\n" +
			"5. Delete the Employee\n");
			
			System.out.println("Enteryour Choice:");
			
			int ch= sc.nextInt();
			switch (ch) {
			case 1:
				employee emp = new employee();
				System.out.println("Enter ID:");
				int id = sc.nextInt();
				System.out.println("Enter Name:");
				String name = sc.next();
				System.out.println("Enter your Salary:");
				double salary =sc.nextDouble();
				System.out.println("Enter your age:");
				int age = sc.nextInt();
				
				emp.setId(id);
				emp.setName(name);
				emp.setSalary(salary);
				emp.setAge(age);
				
				dao.createEmployee(emp);
				break;
			case 2:
				dao.showAllEmployee();
				break;
			
			case 3:
				System.out.println("Enter the ID of the Employee for Details :");
				int empid = sc.nextInt();
				
				dao.showEmployeeBasedOnId(empid);
				break;
				
			case 4:
				System.out.println("Enter the id of employee to update details:");
				int empid1 = sc.nextInt();
				System.out.println("Update the name of the employee:");
				String name1 = sc.next();
				
				dao.updateEmployee(empid1, name1);
				break; 
				
			case 5:
				System.out.println("Enter Employee ID to Delete:");
				int id1 = sc.nextInt();
				dao.deleteEmployee(id1);
				break;
			case 6:
				System.out.println("Thankyou for using our Application !!");
				System.exit(0);
			default :
				System.out.println("Enter a valid choice !!!");
			}
			
			
		} while (true);
	}

}
