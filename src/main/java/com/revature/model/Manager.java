package com.revature.model;

public class Manager extends Users implements Executable {
	
	public boolean approve() {
		return false;
	}
	//public void approve();
	
	public boolean deny() {
		return false;
	}

}
