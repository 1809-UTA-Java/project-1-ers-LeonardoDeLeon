package com.revature.model;

import java.util.ArrayList;
import java.util.List;

import com.revature.model.*;

public class Manager extends Users implements Executable {
	
	private static int APPROVED_STATUS = 215;
	private static int DENIED_STATUS = 213;
	
	public boolean approve(int userId) {
		
		ExpenseReimbursement er = new ExpenseReimbursement();
		List<ExpenseReimbursement> expRbmList = er.getExpRbmDummyTestData();
	
		for (ExpenseReimbursement e : expRbmList) {
			if (e.getAuthorId() == userId && e.getExpRbmStatusId() == Viewable.VIEW_PENDING_ER) {
				e.setExpRbmStatusId(Manager.APPROVED_STATUS);
				return true;
			}
		}
		
		return false;
	}
	//public void approve();
	
	public boolean deny(int userId) {
		
		ExpenseReimbursement er = new ExpenseReimbursement();
		List<ExpenseReimbursement> expRbmList = er.getExpRbmDummyTestData();
		
		for (ExpenseReimbursement e : expRbmList) {
			if (e.getAuthorId() == userId && e.getExpRbmStatusId() == Viewable.VIEW_PENDING_ER) {
				e.setExpRbmStatusId(Manager.DENIED_STATUS);
				return true;
			}
		}
		
		return false;
	}

	public boolean view(int VIEW_CHANNEL) {
		
		boolean isViewable = false;
		Manager m = new Manager();
		ExpenseReimbursement er = new ExpenseReimbursement();
		
		List<Users> userList = m.getUserDummyTestData();		
		List<Users> employeeList = new ArrayList<Users>();
		
		List<ExpenseReimbursement> expRbmList = er.getExpRbmDummyTestData();
		List<ExpenseReimbursement> pendingList = new ArrayList<ExpenseReimbursement>();
		List<ExpenseReimbursement> resolvedList = new ArrayList<ExpenseReimbursement>();
		List<ExpenseReimbursement> withImageList = new ArrayList<ExpenseReimbursement>();
		
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
				// test
				for (Users u : employeeList) {
					if (u.getUserId() == 107) {
						System.out.println(u.toString());						
					}
				}
				isViewable = true;
				break;
			case Viewable.VIEW_MGR_HOME:
				// allow manager to navigate on their dashboard
				// will need list of all employee
				// will need list of all pending reimbursement 
				// will need list of all approved reimbursement
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
								
				// test loop
				for (Users e : employeeList) {
					if (e.getUserRoleId() == Viewable.VIEW_ALL_EMP) {
						// do nothing
						System.out.println(e.toString());
					} else {
						return isViewable = false; // test fail
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
			case Viewable.VIEW_IMAGE_OF_RCPT:
				// allow manager to see the uploaded image
				for (ExpenseReimbursement e : expRbmList) {
					if (e.getReceipt() != null) {
						withImageList.add(e);
					}
				}
				// test	loop		
				for (ExpenseReimbursement e : withImageList) {
					if (e.getReceipt() != null) {
						// do nothing
						System.out.println(e.toString());
					} else {
						return isViewable = false; // test fail
					}
				}
				isViewable = true;
				break;
			case Viewable.VIEW_PENDING_ER:
				// allow manager to see pending expense reimbursement

				for (ExpenseReimbursement e : expRbmList) {
					if (e.getExpRbmStatusId() == Viewable.VIEW_PENDING_ER) {
						pendingList.add(e);
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
				isViewable = true;
				break;
			case Viewable.VIEW_RESOLVED_ER:
				// allow manager to see resolved expense reimbursement
				
				for (ExpenseReimbursement e : expRbmList) {
					if (e.getExpRbmStatusId() == Viewable.VIEW_RESOLVED_ER) {
						resolvedList.add(e);
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
			default:
				// do nothing
				break;
		}
		return isViewable;
	}
}
