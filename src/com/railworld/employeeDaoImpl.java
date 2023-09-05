package com.railworld;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;


public class employeeDaoImpl implements employeeDao  {
	Connection con;
	@Override
	public void createEmployee(employee emp) {
	 con = DBConnection.cerateDBConnection();
	 String query = "insert into employee values(?,?,?,?)";// TODO Auto-generated method stub
	 
	 try {
		 
		 PreparedStatement ps = con.prepareStatement(query);
		 ps.setInt(1, emp.getId());
		 ps.setString(2,emp.getName());
		 ps.setDouble(3, emp.getSalary());
		 ps.setInt(4, emp.getAge());
		 
		 int cnt = ps.executeUpdate();
		 if (cnt!=0) {
			System.out.println("Employee inserted successfully!!!!!");
		};
	} catch (Exception e) {
		e.printStackTrace();// TODO: handle exception
	}
		
	}

	@Override
	public void showAllEmployee() {
		// TODO Auto-generated method stub
		con=DBConnection.cerateDBConnection();
		String query =" select * from employee";
		System.out.println("Employee Details are :");
		System.out.format("%s\t%s\t%s\t%s\n","ID","Name","Salary","Age");
		try {
			Statement st = con.createStatement();
			ResultSet result =st.executeQuery(query);
			
			while (result.next()) {
				System.out.format("%d\t%s\t%f\t%d\n",
						result.getInt(1),
						result.getString(2),
						result.getDouble(3),
						result.getInt(4));
	
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	@Override
	public void showEmployeeBasedOnId(int id) {
		// TODO Auto-generated method stub
		con=DBConnection.cerateDBConnection();
		String query ="select * from employee where id="+id;
		
		try {
			
			Statement st =con.createStatement();
			ResultSet result = st.executeQuery(query);
			
			while (result.next()) {
				System.out.format("%d\t%s\t%f\t%d\n",
						result.getInt(1),
						result.getString(2),
						result.getDouble(3),
						result.getInt(4));
	
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void updateEmployee(int id, String name) {
		// TODO Auto-generated method stub
		con=DBConnection.cerateDBConnection();
		String query="update employee set name=? where id=?";
		
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,name);
			ps.setInt(2 , id);
			
			int cnt = ps.executeUpdate();
			if(cnt!=0) {
				System.out.println("Employee details updated Successfully!!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteEmployee(int id) {
		con=DBConnection.cerateDBConnection();
		String query = " delete from employee where id=? ";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
		int cnt=ps.executeUpdate();
		
		if (cnt !=0) {
			System.out.println("Employee Deleted Successfully !!!"+id );
			
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
