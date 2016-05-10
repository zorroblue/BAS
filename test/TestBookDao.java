package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.hibernate.service.jta.platform.internal.SynchronizationRegistryBasedSynchronizationStrategy;
import org.junit.Test;

import com.itextpdf.text.log.SysoCounter;
import com.mysql.fabric.xmlrpc.base.Array;

import dao.BookDao;
import dao.PublisherDao;
import model.Book;
import model.Publisher;
import model.Vendor;

//tests the Book DAO class
public class TestBookDao 
{	
	@Test
	public void testGetBookByTitle()
	{
		//tests getBookByTitle()
		ArrayList<Book> books=(ArrayList<Book>) new BookDao().getBooksByTitle("Algo");
		//as per our database	
		
		ArrayList<Integer> list=new ArrayList<>();
		for(Book b: books)
		{
			list.add(b.getISBN());
		}
		ArrayList<Integer> expectedResult=new ArrayList<>();
		expectedResult.add(new Integer(1)); 
		assertEquals(expectedResult,list);
	}
	
	@Test
	public void testDoesBookExist()
	{
		boolean result=new BookDao().doesBookExist(2);
		boolean expectedresult=false;
		assertEquals(expectedresult,result);
	}
	
	@Test
	public void testGetBookByISBN()
	{
		Book book=new BookDao().getBookByISBN(2000);
		if(book.getISBN()!=2000)
			fail();
	}
	
	@Test
	public void testAddBook1()
	{
		//add a book not in database
		Book book=new Book();
		book.setAuthorName("Agatha");
		book.setAverageDays(34);
		book.setBookTitle("Murder at the Orient Express");
		book.setImageFileName("F.jpg");
		book.setISBN(123456);
		book.setNoOfCopies(34);
		book.setNoOfRequests(1);
		book.setPrice(100);
		Publisher p=new Publisher();
		p.setPublisherId(213);
		p.setPublisherName("Mithu");
		Vendor v=new Vendor();;
		v.setVendorAddress("ghgj");
		v.setVendorEmail("asSA");
		v.setVendorId(121);
		v.setVendorName("Ram");
		p.setVendor(v);
		book.setPublisher(p);
		book.setRackNo(12);
		book.setThreshold(122);
		new BookDao().addBook(book, 10);
		boolean result=new BookDao().doesBookExist(123456);
		boolean expectedResult=false;
		assertEquals(result,expectedResult);
	}
	
	@Test
	public void testAddBook2()
	{
		//add a book already in database
		//expected that the number of copies will update
		Book book=new BookDao().getBookByISBN(1000);
		Integer no1=book.getNoOfCopies();
		new BookDao().addBook(book, 10);
		Integer no2=new BookDao().getBookByISBN(1000).getNoOfCopies();
		assertEquals(new Integer(no1+10), no2);
	}
	
	@Test
	public void testDeleteBook1()
	{
		//delete an existing book with 0 number of copies
		Integer no=new BookDao().getBookByISBN(2025).getNoOfCopies();
		new BookDao().deleteBook(2025);
		Integer result=new BookDao().getBookByISBN(2025).getNoOfCopies();
		if(result!=no-1 && no!=0)
			fail();
	}
	
	@Test
	public void testDeleteBook2()
	{
		//delete a book not in database
		try
		{
			new BookDao().deleteBook(20201);
		}
		catch(Exception e)
		{
			fail();
		}
		if(new BookDao().doesBookExist(20201))
			fail();
	}
	
	@Test
	public void testGetBooksByAuthorName()
	{
		int flag=0;
		ArrayList<Book> books=(ArrayList<Book>)new BookDao().getBooksByAuthorName("Cormen");
		for(Book b: books)
		{
			if(!b.getBookTitle().equals("ALGO"))
				fail();
		}
	}
	
	@Test 
	public void testUpdateRequests()
	{
		Book book=new BookDao().getBookByISBN(1);
		Integer no=book.getNoOfRequests();
		new BookDao().updateRequests(book);
		Integer result=new BookDao().getBookByISBN(1).getNoOfRequests();
		if(!result.equals(new Integer(no+1)))
			fail();	
	}
	
	@Test
	public void testGetInventoryLevel1()
	{
		//give an ISBN that does not belong to the database
		Integer result=new BookDao().getInventoryLevel(10912);
		if(result!=0)
			fail();
	}

	@Test
	public void testGetInventoryLevel2()
	{
		//give an ISBN that belongs to the database
		Integer result=new BookDao().getInventoryLevel(1);
		Integer inventoryLevel=84;
		if(result!=inventoryLevel)
			fail();
	}
}
