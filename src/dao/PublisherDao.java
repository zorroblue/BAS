package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Publisher;
import views.ErrorDialog;

public class PublisherDao {

	public void addPublisher(Publisher publisher)
	{
		Configuration configuration=new Configuration().configure();
		SessionFactory factory= configuration.buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		
		try
		{
			if(searchPublisherById(publisher.getPublisherId()))
			{
				return;
			}
			else
			{
				session.save(publisher);
				session.save(publisher.getVendor());
				session.getTransaction().commit();
			}
		}
		catch(Exception e)
		{
			if(session.getTransaction()!=null)
				session.getTransaction().rollback();
			e.printStackTrace();
			return;
		}
		finally
		{
			session.close();
		}
	}
	
	public Publisher getPublisherById(Integer Id)
	{
		Configuration configuration=new Configuration().configure();
		SessionFactory factory= configuration.buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		
		try
		{
			Publisher publisher =(Publisher)session.get(Publisher.class, Id);
			return publisher;
		}
		catch(Exception e)
		{
			if(session.getTransaction()!=null)
				session.getTransaction().rollback();
			return null;
		}
		finally
		{
			session.close();
		}
		
	}
	
	public boolean searchPublisherById(Integer Id)
	{
		Configuration configuration=new Configuration().configure();
		SessionFactory factory= configuration.buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		
		try
		{
			Publisher publisher =(Publisher)session.get(Publisher.class, Id);
			if(publisher==null)
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		catch(Exception e)
		{
			if(session.getTransaction()!=null)
				session.getTransaction().rollback();
			return false;
		}
		finally {
			session.close();
		}
	}
}
