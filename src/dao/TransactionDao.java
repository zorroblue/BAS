package dao;

import java.util.Date;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Transaction;
import views.ErrorDialog;

public class TransactionDao {

	public void addTransaction(Transaction transaction)
	{
		Configuration configuration=new Configuration().configure();
		SessionFactory factory= configuration.buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		
		try
		{
			session.save(transaction);
			session.getTransaction().commit();
			return;
		}
		catch(Exception e)
		{
			if(session.getTransaction()!=null)
			{
				session.getTransaction().rollback();
			}
			new ErrorDialog().invoke("Could not add");
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
	}
	
	public Transaction getTransactionById(Integer Id)
	{
		Configuration configuration=new Configuration().configure();
		SessionFactory factory= configuration.buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		
		try
		{
			Transaction transaction=(Transaction)session.get(Transaction.class,	Id);
			return transaction;
		}
		catch(Exception e)
		{
			if(session.getTransaction()!=null)
			{
				session.getTransaction().rollback();
			}
			e.printStackTrace();
			return null;
		}
	}
	
	public String getStatistics()
	{
		Configuration configuration=new Configuration().configure();
		SessionFactory factory= configuration.buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		
		
		return null;
	}
}
