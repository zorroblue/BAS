package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.VendorDao;
import model.Vendor;

public class TestVendorDao {

	@Test
	public void testSearchVendorById()
	{
		boolean result=new VendorDao().searchVendorById(1000);
		boolean expectedResult=true;
		assertEquals(expectedResult,result);
	}
	
	@Test
	public void testGetVendorById()
	{
		Vendor vendor=new VendorDao().getVendorById(1001);
		if(vendor.getVendorId()!=1001)
		{
			fail();
		}
	}
	
	@Test
	public void testAddVendor()
	{
		Vendor vendor=new Vendor();
		vendor.setVendorAddress("ra puram");
		vendor.setVendorEmail("ram@gmail.com");
		vendor.setVendorId(12);
		vendor.setVendorName("Pal");
		new VendorDao().addVendor(vendor);
		boolean result=new VendorDao().searchVendorById(12);
		boolean expectedResult=true;
		assertEquals(expectedResult,result);
	}
}
