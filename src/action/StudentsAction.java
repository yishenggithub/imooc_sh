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
		// �Ž�session��
		if (list != null && list.size() > 0) {
			session.setAttribute("students_list", list);

		}
		return "query_success";
	}
	
	//ɾ��ѧ������
	public String delete()
	{
		StudentsDAO sdao=new StudentsDAOImpl();
		String sid =request.getParameter("sid");
		sdao.deleteStudents(sid);
		return "delete_success";
	}
	
    //�Լ�дadd����
	public String add()
	{
		StudentsDAO sdao=new StudentsDAOImpl();
		sdao.addStudents(s);
		return "add_success";
	}

	//�޸�ѧ�����϶���
	public String modify()
	{
		//��ȡ���ݹ��� ��ѧ�����
		String sid =request.getParameter("sid");
		StudentsDAO sdao=new StudentsDAOImpl();
		Students s =sdao.queryStudentsBySid(sid);
	    //�����ڻỰ��
		session.setAttribute("modify_students", s);
		return "modify_success";
	}
	
	//�����޸ĺ��ѧ�����϶���
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
