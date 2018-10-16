package com.revature.model;

public interface ExpenseReimbursement {
	public boolean view(Employee e);
	//public List<Employee> view(Employee e);
	
	public boolean view(Manager m);
	//public List<Manager> view();
	
	public boolean view(ExpenseReimbursement er);
	//public List<ExpenseReimbursement> view();
	
	public boolean submit(ExpenseReimbursement er);
	//public void submit(ExpenseReimbursement er);
	
	public boolean email(String email, int status);
	//public void email(String email, in status);
}
