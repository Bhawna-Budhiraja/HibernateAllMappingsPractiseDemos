package com.org.gontuseries;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class Main {

	public static void main(String[] args)
	{
		AnnotationConfiguration config=new AnnotationConfiguration();
		config.addAnnotatedClass(Person.class);
		config.addAnnotatedClass(PersonDetail.class);
		config.configure("hibernate.cfg.xml");

		SessionFactory sessionFactory=config.buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();

		PersonDetail pDetail=new PersonDetail();
		pDetail.setIncome("10000.00");
		pDetail.setZipCode("121002");
		pDetail.setJob("IT");

		Person person=new Person();
		person.setPersonName("Pankaj");

		person.setpDetail(pDetail);

		session.save(person);

		session.clear();
		session.getTransaction().commit();

		sessionFactory.close();
	}

}
