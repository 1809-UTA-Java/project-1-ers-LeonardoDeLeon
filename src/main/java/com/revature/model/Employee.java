package com.revature.model;

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
}
