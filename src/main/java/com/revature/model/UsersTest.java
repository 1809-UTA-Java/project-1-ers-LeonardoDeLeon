package com.revature.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class UsersTest {
	Users u = new Users();
	
	@Test
	public void testLoginBothValid() {
	    boolean result = u.login("unobob", "bob123");
	    assertTrue(result);
	}
	
	@Test
	public void testLoginInvalidPassword() {
	    boolean result = u.login("unobob", "thispasswordisbad");
	    assertFalse(result);
	}
	
	@Test
	public void testLoginInvalidUsername() {
	    boolean result = u.login("FredBeGoodIsNotAUser", "bob123");
	    assertFalse(result);
	}
	
	@Test
	public void  testLogoutSuccess() {
		boolean result = u.logout("bannifred");
		assertTrue(result);
	}
	
	@Test
	public void  testLogoutFail() {
		boolean result = u.logout("bannifreddo");
		assertFalse(result);
	}
}
