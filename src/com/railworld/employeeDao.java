package com.railworld;

public interface employeeDao {
	//create employee
	public void createEmployee(employee emp);
	//show all employee
	public void showAllEmployee();
	//show employee by id
	public void showEmployeeBasedOnId( int id);
	//update employee
	public void updateEmployee(int id,String name);
	
	//delete employee
	public void deleteEmployee(int id);

}
