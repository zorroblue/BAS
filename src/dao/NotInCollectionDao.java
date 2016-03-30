package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.NotInCollection;

public class NotInCollectionDao {
	
	//adding a new request is compulsory to have the ISBN code
	public void addRequest(NotInCollection request)
	{
		Configuration configuration=new Configuration().configure();
		SessionFactory factory= configuration.buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		//get all requests for new books
		try
		{
			//check if the book has already been requested for before
			Query newQuery=session.createQuery("from NotInCollection where ISBNCode = :isbn");
			newQuery.setParameter("isbn", request.getISBNCode());
			NotInCollection req=(NotInCollection)newQuery.list();
			if(req==null)
			{
				session.save(request);
			}
			else
			{
				req.setNoOfRequests(req.getNoOfRequests()+1);
				session.update(req);
			}
			session.getTransaction().commit();
		}
		catch(Exception e)
		{
			if(session.getTransaction()!=null)
				session.getTransaction().rollback();
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
	}
	
	public void removeRequest(Integer ISBN) //removes request if the book has been ordered
	{
		Configuration configuration=new Configuration().configure();
		SessionFactory factory= configuration.buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		
		try
		{
			Query query=session.createQuery("from NotInCollection WHERE ISBNCode= :isbn");
			query.setParameter("isbn", ISBN);
			NotInCollection request=(NotInCollection)query.list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	//Function that helps view requests based on descending number of requests.
	//if list is null , then CHECK and give error message.
	public List<NotInCollection> viewRequests()
	{
		Configuration configuration=new Configuration().configure();
		SessionFactory factory= configuration.buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		List<NotInCollection> list=null;
		try
		{
			Query query=session.createQuery("from NotInCollection order by noOfRequests desc");
			list=query.list();
			session.close();
			return list;
		}
		catch(Exception e)
		{
			if(session.getTransaction()!=null)
				session.getTransaction().rollback();
		}
		finally
		{
			session.close();
		}
		return null;
	}

}
