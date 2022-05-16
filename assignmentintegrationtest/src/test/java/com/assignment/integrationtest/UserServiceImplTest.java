package com.assignment.integrationtest;

import com.assignment.integrationtest.data.User;
import com.assignment.integrationtest.data.UserDAO;
import com.assignment.integrationtest.service.SecurityService;
import com.assignment.integrationtest.service.UserServiceImpl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceImplTest {

	private static User user;
	private static UserDAO userDAO;
	private static SecurityService securityService;
	private static UserServiceImpl userServiceImplSUT;

	@BeforeAll
	static void setupTest() {
		// Dummy Class
		securityService = Mockito.mock(SecurityService.class);
		
		// Mock Object
		user = Mockito.mock(User.class);
		userDAO = Mockito.mock(UserDAO.class);
	
		// System Under Test preparation
		userServiceImplSUT = new UserServiceImpl(userDAO, securityService);
	}

	@Test
	void testAssignPassword() throws Exception {
		// Mock Object
		Mockito.when(securityService.md5(user.getPassword())).thenReturn("thisisapasswordbeingset");
		
		// Test
		userServiceImplSUT.assignPassword(user);
		
		// Verify
		Mockito.verify(user).setPassword("thisisapasswordbeingset");
		Mockito.verify(userDAO).updateUser(user);

	}

}
