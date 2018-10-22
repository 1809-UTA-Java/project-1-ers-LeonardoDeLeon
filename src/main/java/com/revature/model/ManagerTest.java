package com.revature.model;

import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.revature.model.Viewable;
import com.revature.model.Manager;

public class ManagerTest {

	Manager m = new Manager();
		
	@Test
	public void testViewAllEmployee() {
	    boolean result = m.view(Viewable.VIEW_ALL_EMP);
	    assertTrue(result);
	}

	@Test
	public void testViewEmployeeInfo() {
	    boolean result = m.view(Viewable.VIEW_EMP_INFO);
	    assertTrue(result);
	}
	
	@Test
	public void testViewMnrHome() {
	    boolean result = m.view(Viewable.VIEW_MGR_HOME);
	    assertTrue(result);
	}
	
	@Test
	public void testViewPendingReimbursement() {
	    boolean result = m.view(Viewable.VIEW_PENDING_ER);
	    assertTrue(result);
	}

	@Test
	public void testViewResolvedReimbursement() {
	    boolean result = m.view(Viewable.VIEW_RESOLVED_ER);
	    assertTrue(result);
	}
	
	@Test
	public void testViewReceiptWithNoImage() {
	    boolean result = m.view(Viewable.VIEW_IMAGE_OF_RCPT);
	    assertTrue(result);
	}
	
	@Test
	public void testViewReceiptWithImage() {
	    boolean result = m.view(Viewable.VIEW_IMAGE_OF_RCPT);
	    assertTrue(result);
	}
	
	@Test
	public void testApproved() {
	    boolean result = m.approve(105);
	    assertTrue(result);
	}
	
	@Test
	public void testApprovedNoSuchUserId() {
	    boolean result = m.approve(104);
	    assertFalse(result);
	}
	
	@Test
	public void testDeny() {
	    boolean result = m.deny(106);
	    assertTrue(result);
	}
	
	@Test
	public void testDenyNoSuchUserId() {
	    boolean result = m.deny(102);
	    assertFalse(result);
	}
}

