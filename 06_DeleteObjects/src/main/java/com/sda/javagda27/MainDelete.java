package com.sda.javagda27;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.sda.javagda27.domain.Employee;

public class MainDelete {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();
		
		Employee employee = entityManager.find(Employee.class, 1L);
		System.out.println("First name: " + employee.getFirstName());
		System.out.println("Last name: " + employee.getLastName());
		System.out.println("Salary: " + employee.getSalary());
		entityManager.remove(employee);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();

	}

}
