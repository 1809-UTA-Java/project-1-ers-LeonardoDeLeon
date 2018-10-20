package com.revature.model;

import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;
import java.sql.Blob;

//import com.revature.repository.ErsDao;
import com.revature.model.ExpenseReimbursement;

public class Employee extends Users implements Editable, Notifiable {

	public boolean upload() {
		return false;
	}
	
	public boolean update(String username, String password) {
		
		List<Users> userList = getUserDummyTestData();
		 
		for (Users u : userList) {
			if (u.getUsername().equals(username)) {
				u.setPassword(password);
				return true;
			}
			
		}
		return false;
	}
	
	public boolean submit(int authorId, double amount, Timestamp submitted, int expRbmTypeId) {
		
		//ExpenseReimbursement er = new ExpenseReimbursement();
		ExpenseReimbursement er = new ExpenseReimbursement(1000,amount,null,null,submitted,null,authorId,10,expRbmTypeId,105);
	

		if (er != null) {
			System.out.println("authorid is "+er.getAuthorId());
			return true;
		}
		return false;
	}
	
	public boolean notifyByEmail() {
		return false;
	}
	
	public boolean view(int VIEW_CHANNEL) {
		
		boolean isViewable = false;
		Employee emp = new Employee();		
		ExpenseReimbursement er = new ExpenseReimbursement();
		
		List<Users> userList = emp.getUserDummyTestData();
		List<Users> employeeList = new ArrayList<Users>();
		List<ExpenseReimbursement> expRbmList = er.getExpRbmDummyTestData();
		List<ExpenseReimbursement> pendingList = new ArrayList<ExpenseReimbursement>();
		List<ExpenseReimbursement> resolvedList = new ArrayList<ExpenseReimbursement>();
		
		// switch statement with int data type
		switch (VIEW_CHANNEL) {

			case Viewable.VIEW_EMP_HOME:
				// allow employee to navigate on their dashboard
				// will need list of all employee then get the username 
				// will need list of all pending reimbursement 
				// will need list of all resolved reimbursement
				
				for (Users u : userList) {
					if (u.getUserRoleId() == Viewable.VIEW_ALL_EMP) {
						employeeList.add(u);
					}
				}
				
				for (ExpenseReimbursement e : expRbmList) {
					if (e.getExpRbmStatusId() == Viewable.VIEW_PENDING_ER) {
						pendingList.add(e);
					}
				}

				for (ExpenseReimbursement e : expRbmList) {
					if (e.getExpRbmStatusId() == Viewable.VIEW_RESOLVED_ER) {
						resolvedList.add(e);
					}
				}
				
				// test user info
				for (Users u : employeeList) {
					if (u.getUserId() == 107 || u.getUsername().equals("reilolmarie")) {
						System.out.println(u.toString());						
					}
				}
				
				// test	loop		
				for (ExpenseReimbursement e : pendingList) {
					if (e.getExpRbmStatusId() == Viewable.VIEW_PENDING_ER) {
						// do nothing
						System.out.println(e.toString());
					} else {
						return isViewable = false; // test fail
					}
				}
				
				// test loop
				for (ExpenseReimbursement e : resolvedList) {
					if (e.getExpRbmStatusId() == Viewable.VIEW_RESOLVED_ER) {
						// do nothing
						System.out.println(e.toString());
					} else {
						return isViewable = false; // test fail
					}
				}
				
				isViewable = true;
				break;
			case Viewable.VIEW_EMP_INFO:
				// allow employee to see their user info
				for (Users u : userList) {
					if (u.getUserRoleId() == Viewable.VIEW_ALL_EMP) {
						employeeList.add(u);
					}
				}
				// test
				for (Users u : employeeList) {
					if (u.getUserId() == 107) {
						System.out.println(u.toString());						
					}
				}
				isViewable = true;
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
}
