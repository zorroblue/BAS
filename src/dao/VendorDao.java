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
		Configuration configuration=new Configuration().configure();
		SessionFactory factory= configuration.buildSessionFactory();
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
		Configuration configuration=new Configuration().configure();
		SessionFactory factory= configuration.buildSessionFactory();
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
		Configuration configuration=new Configuration().configure();
		SessionFactory factory= configuration.buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		
		try
		{
			Vendor vendor=(Vendor)session.get(Vendor.class, Id);
			session.close();
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
