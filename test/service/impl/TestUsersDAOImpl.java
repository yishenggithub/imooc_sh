package service.impl;

import org.junit.Test;

import entity.Users;
import junit.framework.Assert;
import service.UsersDAO;
import service.impl.UsersDAOImpl;


public class TestUsersDAOImpl {

	@Test 
	public void testUsersLogin()
	{
		Users u =new Users(1,"xiaosan","123456");
		UsersDAO udao =new UsersDAOImpl();
		//Assert.assertEquals(true, udao.usersLogin(u));
		 System.out.print(udao.usersLogin(u));
	}
}
