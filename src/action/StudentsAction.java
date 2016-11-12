package action;

import java.util.List;

import com.opensymphony.xwork2.ModelDriven;

import entity.Students;
import entity.Users;
import service.StudentsDAO;
import service.impl.StudentsDAOImpl;

public class StudentsAction extends SuperAction implements ModelDriven<Students>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Students s=new Students();	
	
	
	public String query() {
		StudentsDAO sdao = new StudentsDAOImpl();
		List<Students> list = sdao.queryAllStudents();
		// 放进session中
		if (list != null && list.size() > 0) {
			session.setAttribute("students_list", list);

		}
		return "query_success";
	}
	
	//删除学生动作
	public String delete()
	{
		StudentsDAO sdao=new StudentsDAOImpl();
		String sid =request.getParameter("sid");
		sdao.deleteStudents(sid);
		return "delete_success";
	}
	
    //自己写add动作
	public String add()
	{
		StudentsDAO sdao=new StudentsDAOImpl();
		sdao.addStudents(s);
		return "add_success";
	}

	//修改学生资料动作
	public String modify()
	{
		//获取传递过来 的学生编号
		String sid =request.getParameter("sid");
		StudentsDAO sdao=new StudentsDAOImpl();
		Students s =sdao.queryStudentsBySid(sid);
	    //保存在会话中
		session.setAttribute("modify_students", s);
		return "modify_success";
	}
	
	//保存修改后的学生资料动作
	public String save()
	{
		StudentsDAO sdao=new StudentsDAOImpl();
		sdao.updateStudents(s);
		return "save_success";
	}
	
	@Override
	public Students getModel() {
		// TODO Auto-generated method stub
		return this.s;
	}
	
	

}
