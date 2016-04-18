package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import dao.PublisherDao;
import model.Publisher;
import model.Vendor;

public class TestPublisherDao {
	
	@Test
	public void testSearchByPublisherId()
	{
		boolean result=new PublisherDao().searchPublisherById(1);
		boolean expectedResult=false;
		assertEquals(expectedResult,result);
	}
	
	@Test
	public void testgetPublisherById()
	{
		Publisher publisher=new PublisherDao().getPublisherById(0);
		Publisher expectedResult=null;
		assertEquals(expectedResult, publisher);
	}

	@Test
	public void testAddPublisher()
	{
		Publisher newPublisher=new Publisher();
		newPublisher.setPublisherId(12211);
		newPublisher.setPublisherName("Kolak");
		newPublisher.setVendor(new Vendor());
		new PublisherDao().addPublisher(newPublisher);
		boolean expectedResult=true;
		boolean result=new PublisherDao().searchPublisherById(12211);
		assertEquals(expectedResult, result);
	}
}
