package entity2;

import java.util.Date;
import java.util.EnumSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.spi.MetadataImplementor;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;
import org.junit.Test;

import db.MyHibernateSessionFactory;
import entity.Students;


public class TestStudents {

	@Test
	public void testSchemaExport()
	{
		//创建配置对象
		Configuration config=new Configuration().configure();
		//创建服务注册对象
		/*ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
	    //创建sessionFactory
		SessionFactory sessionFactory=config.buildSessionFactory(serviceRegistry);
        //创建session对象
		Session session=sessionFactory.getCurrentSession();
	    //创建SchemaExport对象
		SchemaExport export =new SchemaExport();
		
		export.create(true, true);
	*/
		ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().configure().build();
	    Metadata metadata = new MetadataSources(serviceRegistry).buildMetadata();

	    SchemaExport export =new SchemaExport();
	    
	    export.create(EnumSet.of(TargetType.DATABASE), metadata);
	}
	//添加测试数据
	@Test
	public void testSaveStudents()
	{
		Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
	
		Transaction tx=session.beginTransaction();
		
		Students s1=new Students("s1","易","男", new Date(),"东莞");
		Students s2=new Students("s2","晟","男", new Date(),"东莞");
		Students s3=new Students("s3","何","男", new Date(),"东莞");
	
		session.save(s1);
		session.save(s2);
		session.save(s3);
		
		tx.commit();
		
	}

}
