package service.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import db.MyHibernateSessionFactory;
import entity.Users;
import service.UsersDAO;

public class UsersDAOImpl implements UsersDAO {
     
	public boolean usersLogin(Users u){
		//事务对象
		Transaction tx=null;
		String hql="";
		try
		{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
		    tx=session.beginTransaction();
			//hql="from entity.Users  where username=:a and password=:b ";
		    //Query query =session.createQuery(hql); //为什么这里老是过不去？
		    
		    String sql = "select * from users where username=? and password=? ";
			Query query = session.createSQLQuery(sql);
			
			query.setParameter(0, u.getUsername());
		    query.setParameter(1, u.getPassword());
		    
		    List list =query.getResultList();
		    tx.commit();//提交事务
		    
		    if(list.size()>0)
		    {
		    	System.out.println("test");
		    	return true;
		    }
		    else
		    {
		    	System.out.println("test");
		    	return false;
		    }
		    
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		finally
		{
			if(tx!=null)
			{
				tx=null;
			}
		}
	}
}
