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
	
	public void addBook(Book thebook,Integer quantity)
	{
		Configuration configuration=new Configuration().configure();
		SessionFactory factory= configuration.buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		thebook.setNoOfCopies(quantity);
		try
		{
			Integer ISBN=thebook.getISBN();
			Book book=(Book)session.get(Book.class, ISBN);
			if(book==null) //no book exists
			{
				session.save(thebook);
				session.getTransaction().commit();
				new SuccessDialog().invoke("Done!");
				session.close();
				return;
			}
			book.setNoOfCopies(book.getNoOfCopies()+quantity);
			session.update(book);
			session.getTransaction().commit();
			new SuccessDialog().invoke("Done!");
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
		Configuration configuration=new Configuration().configure();
		SessionFactory factory= configuration.buildSessionFactory();
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
		
		Configuration configuration=new Configuration().configure();
		SessionFactory factory= configuration.buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		Query query=session.createQuery("from Book where bookTitle = :thetitle");
		query.setString("thetitle",title);
		List<Book> bookList=(List<Book>)query.list();
		return bookList;

	}
	
	public List<Book> getBooksByAuthorName(String authorName)
	{
		Configuration configuration=new Configuration().configure();
		SessionFactory factory= configuration.buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		Query query=session.createQuery("from Book where authorName = :authorname");
		query.setString("authorname", authorName.toUpperCase());
		List<Book> bookList=(List<Book>)query.list();
		return bookList;
		
	}

}
