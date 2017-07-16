package org.com.HibernateSession;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Worker {
	
	@Id
	@GeneratedValue
	private int workerId;
	private String workerName;
	private double salary;
	
	@ManyToMany(cascade=CascadeType.ALL)
	private Set<Department> Department=new HashSet<Department>();
	
	public Set<Department> getDepartment() {
		return Department;
	}
	public void setDepartment(Set<Department> department) {
		Department = department;
	}
	public int getWorkerId() {
		return workerId;
	}
	public void setWorkerId(int workerId) {
		this.workerId = workerId;
	}
	public String getWorkerName() {
		return workerName;
	}
	public void setWorkerName(String workerName) {
		this.workerName = workerName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
}
