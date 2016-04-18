package dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InitialiseSFHibernate {

	public static Configuration configuration=new Configuration().configure();
	public static SessionFactory factory= configuration.buildSessionFactory();

	public SessionFactory getSessionFactory()
	{
		return factory;
	}
}