package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import model.Book;
import views.ErrorDialog;
import views.SuccessDialog;

//Manages the basic CRUD operations on the Book table
public class BookDao {
	
	//add quantity number of books to the inventory
	public void addBook(Book thebook,Integer quantity)
	{
		SessionFactory factory=new InitialiseSFHibernate().getSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		
		try
		{
			Integer ISBN=thebook.getISBN();
			Book book=(Book)session.get(Book.class, ISBN);
			if(book==null) //no book exists
			{
				//check if the book has been requested in notInCollection
				new NotInCollectionDao().removeRequest(ISBN);
				
				thebook.setNoOfCopies(quantity);
				session.save(thebook);
				session.getTransaction().commit();
		//		session.close();
				return;
			}
			if(book.getNoOfCopies()+quantity<0)
			{
				new ErrorDialog().invoke("Request can't be processed");
				return;
			}
			book.setNoOfCopies(book.getNoOfCopies()+quantity);
			if(quantity>0)
			{
				//we have got new copies of the same
				book.setNoOfRequests(0);
			}
			session.update(book);
			session.getTransaction().commit();
			//new SuccessDialog().invoke("Done!");
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
	
	public void deleteBook(Integer ISBN)
	{
		SessionFactory factory=new InitialiseSFHibernate().getSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		Book book=(Book)session.get(Book.class,ISBN);
		if(book==null)
		{
			new ErrorDialog().invoke("No such book exists!");
			return;
		}
		if(book.getNoOfCopies()==0) //no more books left
		{
			new ErrorDialog().invoke("No more copies left to delete!");
			return;
		}
		try
		{
			book.setNoOfCopies(book.getNoOfCopies()-1);
			session.update(book);
			new SuccessDialog().invoke("Successfully deleted!");
			session.getTransaction().commit();
		}
		catch(Exception e)
		{
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
	}
	
	public List<Book> getBooksByTitle(String title)
	{
		
		SessionFactory factory=new InitialiseSFHibernate().getSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		Query query=session.createQuery("from Book where bookTitle = :thetitle");
		query.setString("thetitle",title);
		List<Book> bookList=(List<Book>)query.list();
		session.close();
		return bookList;

	}
	
	public List<Book> getBooksByAuthorName(String authorName)
	{
		SessionFactory factory=new InitialiseSFHibernate().getSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		Query query=session.createQuery("from Book where authorName = :authorname");
		query.setString("authorname", authorName.toUpperCase());
		List<Book> bookList=(List<Book>)query.list();
		session.close();
		return bookList;
		
	}
	
	public boolean doesBookExist(Integer ISBN)
	{
		SessionFactory factory=new InitialiseSFHibernate().getSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		Book book=(Book)session.get(Book.class, ISBN);
		session.close();
		if(book==null)
		{
			return false;
		}
		return true;
	}
	
	public Book getBookByISBN(Integer ISBN)
	{
		SessionFactory factory=new InitialiseSFHibernate().getSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		Book book=(Book)session.get(Book.class, ISBN);
		session.close();
		return book;
	}
	
	public void updateRequests(Book thebook)
	{
		SessionFactory factory=new InitialiseSFHibernate().getSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		try
		{
			Book book=(Book)session.get(Book.class, thebook.getISBN());
			book.setNoOfRequests(book.getNoOfRequests()+1);
			session.update(book);
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
	
	public List<Book> getRequests()
	{
		SessionFactory factory=new InitialiseSFHibernate().getSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		try
		{
			Query query=session.createQuery("from Book b where b.noOfRequests>0 order by b.noOfRequests desc");
			List<Book> list=query.list();
			return list;
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
		
		return null;
	}

	public Integer getInventoryLevel(Integer ISBN)
	{
		SessionFactory factory=new InitialiseSFHibernate().getSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		try
		{
			Book book=(Book)session.get(Book.class, ISBN);
			if(book==null)
			{
				new ErrorDialog().invoke("No such book exists!");
				return 0;
			}
			else
			{
				Integer no=new TransactionDao().getNoOfCopiesSold(ISBN);
				return no*book.getAverageDays();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return 0;
		}
		finally
		{
			session.close();	
		}
	}
	
	public List<Book> getBooksBelowThreshold()
	{
		SessionFactory factory=new InitialiseSFHibernate().getSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		try
		{
			Query query=session.createQuery("from Book where noOfCopies<threshold");
			List<Book> list=query.list();
			return list;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		finally
		{
			session.close();
		}
	}
	
}