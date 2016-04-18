package tests;

import static org.junit.Assert.assertEquals;

import org.hibernate.SessionFactory;
import org.junit.Test;

import dao.InitialiseSFHibernate;

//test class to test database connection and hibernate mappings
public class TestConnection {

	
	@Test
	public void testConnection()
	{
		boolean expectedResult=true,result;
		SessionFactory factory=new InitialiseSFHibernate().getSessionFactory();
		if(factory==null)
			result=false;
		else
			result=true;
		assertEquals(expectedResult,result);
		System.out.println("Database connection is successful");
	}
}
