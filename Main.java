package Hibernate;

import org.hibernate.*;
import org.hibernate.cfg.*;

public class Main 
{
	public static void main(String[] args)
	{
		Configuration c = new Configuration();
		c.configure("hibernate.cfg.xml");
		SessionFactory factory = c.buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		Employee e1 = new Employee();
		e1.setEmpname("Sejal Nikam");
		e1.setSalary(87905);
		
		Address a1 = new Address();
		a1.setCity("Malegaon");
		a1.setState("MH");
		a1.setCountry("India");
		a1.setEmp(e1);
		e1.setAddr(a1);
		
		session.persist(a1);
		session.persist(e1);
		
		t.commit();
		session.close();
	}
}
