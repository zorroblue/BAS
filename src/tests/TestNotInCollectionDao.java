package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import dao.NotInCollectionDao;
import dao.TransactionDao;
import model.NotInCollection;
import model.Transaction;

//checks the NotInCollectionDao
public class TestNotInCollectionDao {

	@Test
	public void testAddRequest()
	{
		NotInCollection request=new NotInCollection();
		request.setAuthorName("ABC");
		request.setBookTitle("Agatha");
		request.setISBNCode(12213);
		request.setNoOfRequests(2);
		request.setPublisherName("Marvel");
		request.setRequestId(121);
		try
		{
			new NotInCollectionDao().addRequest(request);
		}
		catch(Exception e)
		{
			fail();
		}
	}
	
	@Test
	public void testViewRequest()
	{
		int flag=1;
		ArrayList<NotInCollection> collection=(ArrayList<NotInCollection>) new NotInCollectionDao().viewRequests();
		for(NotInCollection c: collection)
		{
			if(c.getISBNCode()==123)
			{
				flag=0;
				break;
			}
		}
		if(flag==1)
		{
			fail();
		}
	}
	
	@Test
	public void removeRequest()
	{
		int flag=1;
		new NotInCollectionDao().removeRequest(1221);
		boolean expectedResult=true,result=true;
		for(NotInCollection c: new NotInCollectionDao().viewRequests())
		{
			if(c.getISBNCode()==1221)
			{
				result=false;
			}
		}
		assertEquals(expectedResult,result);
	}
}
