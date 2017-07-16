package org.com.HibernateSession;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {

		Configuration config=new Configuration();
		config.addAnnotatedClass(Worker.class);
		config.addAnnotatedClass(Department.class);
		config.configure("hibernate.cfg.xml");

		Worker worker1=new Worker();
		worker1.setWorkerName("bhawna1");
		worker1.setSalary(1000.00);
		
		
        Worker worker2=new Worker();
		worker2.setWorkerName("bhawna2");
		worker2.setSalary(2000.00);

		Worker worker3=new Worker();
		worker3.setWorkerName("bhawna2");
		worker3.setSalary(2000.00);

		Department department1=new Department();
		department1.setDepName("IT1");

		Department department2=new Department();
		department2.setDepName("HR1");

		Department department3=new Department();
		department3.setDepName("Finance1");

		Set<Department> departmentSet1=new HashSet<Department>();
		departmentSet1.add(department1);
		departmentSet1.add(department2);
		departmentSet1.add(department3);

		Department department4=new Department();
		department4.setDepName("IT2");

		Department department5=new Department();
		department5.setDepName("HR2");

		Department department6=new Department();
		department6.setDepName("Finance2");

	    Set<Department> departmentSet2=new HashSet<Department>();
		departmentSet2.add(department4);
		departmentSet2.add(department5);
		departmentSet2.add(department6);
		
		Department department7=new Department();
		department7.setDepName("IT2");

		Department department8=new Department();
		department8.setDepName("HR2");

		Department department9=new Department();
		department9.setDepName("Finance2");

	    Set<Department> departmentSet3=new HashSet<Department>();
		departmentSet3.add(department7);
		departmentSet3.add(department8);
		departmentSet3.add(department9);

	    SessionFactory sessionFactory=config.buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();

		worker1.setDepartment(departmentSet1);
		worker2.setDepartment(departmentSet2);
		worker3.setDepartment(departmentSet3);
		
		session.save(worker1);
		session.save(worker2);
		session.save(worker3);

		session.flush();
		session.getTransaction().commit();

		session.close();
		sessionFactory.close();


	}

}
