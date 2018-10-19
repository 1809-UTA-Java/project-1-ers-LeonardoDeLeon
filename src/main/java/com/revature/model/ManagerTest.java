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
}

