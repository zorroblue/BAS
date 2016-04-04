package dao;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Book;
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
			session.close();
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
			session.close();
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
		
		finally
		{
			session.close();
		}
	}
	
	public String getStatistics(Date fromDate, Date toDate)
	{
		Configuration configuration=new Configuration().configure();
		SessionFactory factory= configuration.buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		
		try
		{
			
				Query query2=session.createSQLQuery("select bookISBN,cast(sum(noOfCopies) as SIGNED) as 'count' from transaction where dateOfTransaction BETWEEN :fromDate AND :toDate group by bookISBN;");
				query2.setParameter("fromDate", fromDate);
				query2.setParameter("toDate", toDate);
				List resultList=query2.list();
				
				
				session.close();
				if(resultList==null)
					return new String("");
				StringBuilder stringBuilder=new StringBuilder("RESULTS:\n\n");
				int k=0;
				for (Iterator iter = resultList.iterator(); iter.hasNext();) {
				     Object[] objects = (Object[]) iter.next();
				     Integer ISBN = (Integer) objects[0];
				     Integer count = ((BigInteger)objects[1]).intValue();
				   //  book name, publisher, ISBN number, number of copies sold, and the sales revenue
				     Book book=new BookDao().getBookByISBN(ISBN);
				     if(book==null)
				     {
				    	 System.out.println("DEBUG: Book 123"+" ISBN:"+ISBN);
				    	 continue;
				     }
				     //BigInteger revenue=count.multiply(new BigInteger(book.getPrice().intValue()));
				     stringBuilder.append(++k +". Book Name: "+book.getBookTitle()+"\nPublisherName: "+book.getAuthorName()+"\nISBN :"+book.getISBN()+"\nNo of copies sold: "+count+"\nSales revenue: "+count*book.getPrice());
				     
				}
				//System.out.println(stringBuilder.toString());
				return stringBuilder.toString();
			
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		
		
		return null;
	}
	
	
	
}
