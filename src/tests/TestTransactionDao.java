package tests;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import dao.TransactionDao;
import model.Transaction;

public class TestTransactionDao {
	
	@Test
	public void testgetTransactionById()
	{
		Transaction transaction=new TransactionDao().getTransactionById(13);
		boolean result=true;
		if(transaction==null)
		{
			result=false;
		}
		else
		{
			result=true;
		}
		boolean expectedResult=false;
		assertEquals(expectedResult,result);
	}
	
	@Test 
	public void testgetNoOfCopiesSold()
	{
		Integer result=new TransactionDao().getNoOfCopiesSold(1);
		Integer expectedresult=new Integer(7);
		assertEquals(expectedresult, result);
	}

	@Test
	public void testgetStatistics()
	{
		Calendar calendar=Calendar.getInstance();
		//corner case when the to date is given to be more than start date
		calendar.add(Calendar.DATE, -1);
		String result=new TransactionDao().getStatistics(new Date(), calendar.getTime() );
		String expectedResult=new String("RESULTS:\n\n");
		assertEquals(expectedResult, result);
	}
}
