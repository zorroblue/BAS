import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Book;
import model.Publisher;
import model.SalesDay;
import model.Vendor;

public class Application {
	public static void main(String args[])
	{
/*		Configuration configuration=new Configuration().configure();
		SessionFactory factory= configuration.buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		Employee employee=new Employee();
		employee.setId(10000);
		employee.setName("Rameshwar");
		
		employee.setPassword("user123");
		
		
		session.save(employee);
		
		Vendor vendor=new Vendor();
		vendor.setVendorAddress("Chennai");
		vendor.setVendorEmail("me@gmail.com");
		vendor.setVendorName("Ravi Book store");
		vendor.setVendorId(2112112);
		session.save(vendor);
		
		SalesDay salesDay=new SalesDay();
		salesDay.setDate(new Date(1, 12, 2014));
		
		Publisher publisher=new Publisher();
		publisher.setPublisherId(2152112);
		publisher.setPublisherName("Spring");
		publisher.setVendor(vendor);
		session.save(publisher);
		
		Book book=new Book();
		book.setAuthorName("Cormen");
		book.setAverageDays(212);
		book.setBookTitle("Algorithms");
		book.setISBN(119112122);
	//	book.setNoOfRequests(98);
		book.setNoOfCopies(12);
		book.setPrice(1222);
		book.setPublisher(publisher);
		book.setRackNo(1);
		salesDay.getBooksSold().add(book);
		session.save(book);
		
		Book book1=new Book();
		book1.setAuthorName("Cormen");
		book1.setAverageDays(212);
		book1.setBookTitle("Functional Equations");
		book1.setISBN(21211212);
	//	book.setNoOfRequests(98);
		book1.setNoOfCopies(12);
		book1.setPrice(1222);
		book1.setPublisher(publisher);
		book1.setRackNo(1);
		session.save(book1);
		
		salesDay.getBooksSold().add(book1);
		session.save(salesDay);
		session.getTransaction().commit();
		
		*/
		
	}

}
