package com.revature.model;

import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Timestamp;

import com.revature.model.Viewable;
import com.revature.model.Employee;

public class EmployeeTest {
	Employee e = new Employee();
	
	@Test
	public void testViewEmployeeHome() {
	    boolean result = e.view(Viewable.VIEW_EMP_HOME);
	    assertTrue(result);
	}
	
	@Test
	public void testViewPendingReimbursement() {
	    boolean result = e.view(Viewable.VIEW_PENDING_ER);
	    assertFalse(result);
	}

	@Test
	public void testViewResolvedReimbursement() {
	    boolean result = e.view(Viewable.VIEW_RESOLVED_ER);
	    assertFalse(result);
	}
	
	@Test
	public void testSubmitReimbursement() {
	    boolean result = e.submit(107,40.23,Timestamp.valueOf("2018-09-23 10:10:10.000000000"),105);
	    assertTrue(result);
	}	
	
	@Test
	public void testUpdateUserInfo() {
	    boolean result = e.update("unobob","bobo224");
	    assertTrue(result);
	}	
	
}
