package com.revature.model;

import java.util.ArrayList;
import java.util.List;

import com.revature.repository.ErsDao;

public class Employee extends Users implements Editable, Notifiable {

	public boolean upload() {
		return false;
	}
	
	public boolean update() {
		return false;
	}
	
	public boolean submit() {
		return false;
	}
	
	public boolean notifyByEmail() {
		return false;
	}
	
	public boolean view(int VIEW_CHANNEL) {
		
		boolean isViewable = false;
		
		List<Users> userList = getUserDummyTestData();
		
		List<Users> employeeList = null;
		
		// switch statement with int data type
		switch (VIEW_CHANNEL) {

			case Viewable.VIEW_EMP_HOME:
				// allow employee to navigate on their dashboard
				employeeList = new ArrayList<Users>();
				for (Users u : userList) {
					if (u.getUserRoleId() == Viewable.VIEW_ALL_EMP) {
						employeeList.add(u);
					}
				}
				break;
			case Viewable.VIEW_EMP_INFO:
				// allow employee to see their user info
				break;				
			case Viewable.VIEW_PENDING_ER:
				// allow employee to view their pending request
				break;
			case Viewable.VIEW_RESOLVED_ER:
				// allow employee to see their resolved request
				break;				
			default:			
				break;
		}
		return isViewable;
	}
	
	public static void main (String [] args) {
		//ErsDao ed = new ErsDao();
		//Users u = new Users();
		
		//List<Employee> empList = ed.getUsersByUserRoleId(55);
		
		//List<Employee> empList = 
		
		Employee e = new Employee();
		System.out.println("e.getUserId() = "+e.getUserId());
	}
}
