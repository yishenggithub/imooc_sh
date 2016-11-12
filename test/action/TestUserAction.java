package action;

import org.junit.Test;

import entity.Users;
import service.UsersDAO;
import service.impl.UsersDAOImpl;

public class TestUserAction {

	@Test
	public void testUsersLogin()
	{
		Users u =new Users(1,"xiaosan","123456");
		//UsersDAO udao =new UsersDAOImpl();
		UsersAction ua=new UsersAction();
	
		ua.getModel().setPassword("123456");
		ua.getModel().setUsername("xiaosan");
		ua.getModel().setUid(1);
		System.out.println(ua.getModel().getUsername()+ua.getModel().getPassword());
		System.out.println(ua.login());
	}
}

