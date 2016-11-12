package db;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class MyHibernateSessionFactory {
   private static  SessionFactory sessionFactory;
   
   //���췽��˽�л�����֤����ģʽ
   private MyHibernateSessionFactory()
   {
	   
   }
   
   //�еľ�̬��������ûỰ��������
   public static SessionFactory getSessionFactory()
   {
	   if(sessionFactory==null)
	   {
		   /*
		   Configuration config =new Configuration().configure();
		   ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		   sessionFactory=config.buildSessionFactory(serviceRegistry);
		   */
		  
		   //�°洴��sessionFactory
		   ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().configure().build();
		   Metadata metadata = new MetadataSources(serviceRegistry).buildMetadata();
		   sessionFactory=metadata.getSessionFactoryBuilder().build();
		    
		   return sessionFactory;
	   }
	   else
	   {
		   return sessionFactory;
	   }
   }
}
