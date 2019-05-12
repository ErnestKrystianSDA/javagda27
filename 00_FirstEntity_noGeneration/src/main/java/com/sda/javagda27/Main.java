package com.sda.javagda27;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.sda.javagda27.domain.Employee;


public class Main {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Employee employee = new Employee();
		employee.setId(1l);
		employee.setFirstName("Ernest");
		employee.setLastName("Krystian");
		employee.setSalary(20.4);
		
		Employee employee2 = new Employee();
		employee2.setId(0l);
		employee2.setFirstName("Lolek");
		employee2.setLastName("Bolek");
		employee2.setSalary(20.4);
		
		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.persist(employee2);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
	}

}
