package dao;

import java.math.BigInteger;
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
		SessionFactory factory=new InitialiseSFHibernate().getSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		
		try
		{
			session.save(transaction);
			session.getTransaction().commit();
			//session.close();
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
		SessionFactory factory=new InitialiseSFHibernate().getSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		
		try
		{
			Transaction transaction=(Transaction)session.get(Transaction.class,	Id);
			//session.close();
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
		SessionFactory factory=new InitialiseSFHibernate().getSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		
		try
		{
			
				Query query2=session.createSQLQuery("select bookISBN,cast(sum(noOfCopies) as SIGNED) as 'count' from transaction where dateOfTransaction BETWEEN :fromDate AND :toDate group by bookISBN;");
				query2.setParameter("fromDate", fromDate);
				query2.setParameter("toDate", toDate);
				List resultList=query2.list();
				
				
		//		session.close();
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
				     stringBuilder.append(++k +". Book Name: "+book.getBookTitle()+"\nAuthorName: "+book.getAuthorName()+"\nPublisher Name: "+book.getPublisher().getPublisherName()+"\nISBN :"+book.getISBN()+"\nNo of copies sold: "+count+"\nSales revenue: "+count*book.getPrice()+"\n\n"); //changed123
				     
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
	
	public Integer getNoOfCopiesSold(Integer ISBN)
	{
		SessionFactory factory=new InitialiseSFHibernate().getSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		
		try
		{
				Date toDate=new Date();
				Calendar calendar=Calendar.getInstance();
				calendar.add(Calendar.DATE,-14);
				Date fromDate=calendar.getTime();
				Query query2=session.createSQLQuery("select cast(sum(noOfCopies) as SIGNED) as 'count' from transaction where bookISBN= :isbn and dateOfTransaction BETWEEN :fromDate AND :toDate group by bookISBN;");
				query2.setParameter("fromDate", fromDate);
				query2.setParameter("toDate", toDate);
				query2.setParameter("isbn", ISBN);
				List resultList=query2.list();
				if(resultList==null || resultList.isEmpty())
					return 0;
				Integer result=0;
				for (Iterator iter = resultList.iterator(); iter.hasNext();) 
				{
				     BigInteger object=(BigInteger)iter.next();
				     result=(object).intValue();
				}
				return result;   
			}
		catch(Exception e)
		{
			if(session.getTransaction()==null)
				session.getTransaction().rollback();
			e.printStackTrace();
			return 0;
		}
		finally
		{
			session.close();
		}
	}
				


				
	
}
