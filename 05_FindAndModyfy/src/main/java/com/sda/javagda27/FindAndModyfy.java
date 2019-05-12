package com.sda.javagda27;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.sda.javagda27.domain.Employee;

public class FindAndModyfy {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();
		
		Employee employee = entityManager.find(Employee.class, 1L);
		System.out.println("First name: " + employee.getFirstName());
		System.out.println("Last name: " + employee.getLastName());
		System.out.println("Salary: " + employee.getSalary());
		employee.setSalary(600);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();

	}

}
