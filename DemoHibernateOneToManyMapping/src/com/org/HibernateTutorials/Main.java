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

		Worker worker1=new Worker();
		worker1.setWorkerName("bhawna2");
		worker1.setSalary(1000.00);

		Worker worker2=new Worker();
		worker2.setWorkerName("bhawna2");
		worker2.setSalary(2000.00);

		Worker worker3=new Worker();
		worker3.setWorkerName("bhawna2");
		worker3.setSalary(3000.00);

		Department department=new Department();
		department.setDepName("bhanu");
		
		department.getWorker().add(worker1);
		department.getWorker().add(worker2);
		department.getWorker().add(worker3);

		SessionFactory sessionFactory=config.buildSessionFactory();
		Session session=sessionFactory.openSession();

		session.beginTransaction();
		session.save(department);
		session.flush();

		session.getTransaction().commit();
		session.close();
		sessionFactory.close();	
		
	}

}
