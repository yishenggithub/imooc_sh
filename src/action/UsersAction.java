 package action;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ModelDriven;

import entity.Users;
import service.UsersDAO;
import service.impl.UsersDAOImpl;

public class UsersAction extends SuperAction implements ModelDriven<Users>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Users user=new Users();
	
	//用户登录动作
	public String login()
	{
		UsersDAO udao=new UsersDAOImpl();
		if(udao.usersLogin(user))
		{
			session.setAttribute("loginUserName", user.getUsername());
			return "login_success";
		}
		else
		{
			return "login_failure";
		}
	}
	
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		if("".equals(user.getUsername().trim()))
		{
			this.addFieldError("usernameError", "用户名不能为空!");
		}
		else if(user.getPassword().length()<6)
		{
			this.addFieldError("passwordError", "密码长度少于6位");
		}
	}

	//用户注销方法
	@SkipValidation
	public String logout()
	{
		if(session.getAttribute("loginUserName")!=null)
		{
			session.removeAttribute("loginUserName");
		}
		return "logout_success";
	}
	
	public Users getModel() {
		// TODO Auto-generated method stub
		return this.user;
	}

}
