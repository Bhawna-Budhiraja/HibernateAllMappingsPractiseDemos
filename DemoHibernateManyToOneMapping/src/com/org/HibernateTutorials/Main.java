package com.org.HibernateTutorials;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
	
	public static void main(String[] args)
	{
		Configuration config=new Configuration();
		config.addAnnotatedClass(Worker.class);
		config.addAnnotatedClass(Department.class);
		config.configure("hibernate.cfg.xml");

		Department department1=new Department();
		department1.setDepName("IT");
		
		Department department2=new Department();
		department2.setDepName("HR");
		
		Worker worker1=new Worker();
		worker1.setName("bhawna1");
		worker1.setSalary(1000.00);
		
		Worker worker2=new Worker();
		worker2.setName("bhawna1");
		worker2.setSalary(1000.00);
		
		Worker worker3=new Worker();
		worker3.setName("bhawna1");
		worker3.setSalary(1000.00);
		
        worker1.setDepartment(department1);
        worker2.setDepartment(department2);
        worker3.setDepartment(department1);
        
        SessionFactory sessionFactory=config.buildSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        
        session.save(worker1);
        session.save(worker2);
        session.save(worker3);
        
        session.flush();
        
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
		
		
	}

}
