package com.sda.javagda27;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.sda.javagda27.domain.Employee;

public class MainAddEmployees {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;

	public static void main(String[] args) {
		entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		entityManager = entityManagerFactory.createEntityManager();

		addEmployees();

		entityManager.close();
		entityManagerFactory.close();
	}

	private static void addEmployees() {
		addEmployee("Karol", "Mokasyn", 1000);
		addEmployee("Marika", "Ratownika", 1200);
		addEmployee("Janko", "Muzykant", 10000);
		addEmployee("Daria", "Nokaudia", 2003);
		addEmployee("Ernest", "Krystian", 2345);
		addEmployee("Kamil", "Bednarek", 100000);
		addEmployee("Przemek", "Mokasyn", 23454);
		addEmployee("Agnieszka", "Tutajnie", 4339);
		addEmployee("Kuba", "Jastrzebski", 32323);
		addEmployee("Angelika", "Mia³kowska", 3232);
		addEmployee("Barbara", "Nowak", 3232);
	}

	private static void addEmployee(String firstName, String lastName, double salary) {
		Employee employee = new Employee();
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setSalary(salary);

		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.getTransaction().commit();

	}

}
