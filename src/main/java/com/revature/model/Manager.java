package com.revature.model;

import java.util.ArrayList;
import java.util.List;

import com.revature.model.*;

public class Manager extends Users implements Executable {
	
	public boolean approve() {
		return false;
	}
	//public void approve();
	
	public boolean deny() {
		return false;
	}

	public boolean view(int VIEW_CHANNEL) {
		
		boolean isViewable = false;
		Manager m = new Manager();
		
		List<Users> userList = m.getUserDummyTestData();
		
		List<Users> employeeList = new ArrayList<Users>();
		
		// switch statement with int data type
		switch (VIEW_CHANNEL) {
			case Viewable.VIEW_ALL_EMP:
				// allow manager to view list of all employee
				
				for (Users u : userList) {
					if (u.getUserRoleId() == Viewable.VIEW_ALL_EMP) {
						employeeList.add(u);
					}
				}
				// loop through again for testing purpose to match roleId 
				for (Users e : employeeList) {
					if (e.getUserRoleId() == Viewable.VIEW_ALL_EMP) {
						// do nothing
					} else {
						return isViewable = false; // test fail
					}
				}
				isViewable = true;
					
				break;
			case Viewable.VIEW_EMP_INFO:
				// allow manager to look into an employee user info
				for (Users u : userList) {
					if (u.getUserRoleId() == Viewable.VIEW_ALL_EMP) {
						employeeList.add(u);
					}
				}
				// Manager supplies the username or userId to show emp info ie, userId = 107
				for (Users u : employeeList) {
					if (u.getUserId() == 107) {
						System.out.println(u.toString());						
					}
				}
				isViewable = true;
				break;
			case Viewable.VIEW_MGR_HOME:
				// allow manager to navigate on their dashboard
				break;
			case Viewable.VIEW_IMAGE_OF_RCPT:
				// allow manager to see the uploaded image
				break;
			case Viewable.VIEW_PENDING_ER:
				// allow manager to see pending expense reimbursement
				break;
			case Viewable.VIEW_RESOLVED_ER:
				// allow manager to see resolved expense reibursement
				break;				
			default:
				
				break;
		}
		return isViewable;
	}
}
