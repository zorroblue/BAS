package tests;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;


public class TestRunner {

	public static void main(String args[])
	{
		Result result=JUnitCore.runClasses(TestBookDao.class,TestPublisherDao.class,TestTransactionDao.class,TestConnection.class,TestNotInCollectionDao.class,TestVendorDao.class);
		for (Failure failure: result.getFailures())
		{
			System.out.println(failure.toString());
		}
		System.out.println("STATUS OF TESTING: "+result.wasSuccessful());
	}

}
