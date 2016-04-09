package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Publisher;
import model.Vendor;
import views.SuccessDialog;

public class VendorDao {
	
	public void addVendor(Vendor vendor)
	{
		SessionFactory factory=new InitialiseSFHibernate().getSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		
		try
		{
			if(searchVendorById(vendor.getVendorId()))
			{
				new SuccessDialog().invoke("Vendor exists");
	//			session.close();
				return;
			}
			else
			{
				session.save(vendor);
				
				session.getTransaction().commit();
				System.out.println("Vendor added!"+vendor.getVendorId());
			}
		}
		catch(Exception e)
		{
			if(session.getTransaction()!=null)
				session.getTransaction().rollback();
			e.printStackTrace();
			return;
		}
		finally {
			session.close();
		}
	}
	
	public Vendor getVendorById(Integer Id)
	{
		SessionFactory factory=new InitialiseSFHibernate().getSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		
		try
		{
			Vendor vendor=(Vendor)session.get(Vendor.class, Id);
			return vendor;
		}
		catch(Exception e)
		{
			if(session.getTransaction()!=null)
				session.getTransaction().rollback();
			return null;
		}
		finally
		{
			session.close();
		}
		
	}
	
	public boolean searchVendorById(Integer Id)
	{
		SessionFactory factory=new InitialiseSFHibernate().getSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		
		try
		{
			Vendor vendor=(Vendor)session.get(Vendor.class, Id);
			if(vendor==null)
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		catch(Exception e)
		{
			if(session.getTransaction()!=null)
				session.getTransaction().rollback();
			return false;
		}
		finally
		{
			session.close();
		}
	}

}
