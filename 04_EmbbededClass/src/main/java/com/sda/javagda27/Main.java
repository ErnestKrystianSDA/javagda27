package com.sda.javagda27;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.sda.javagda27.domain.Addres;
import com.sda.javagda27.domain.Employee;


public class Main {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Employee employee = new Employee();
		Addres addres = new Addres();
		employee.setFirstName("Ernest");
		employee.setLastName("Krystian");
		employee.setSalary(1111.2);
		employee.setAddres(addres);
		addres.setLocality("Gdañsk");
		addres.setZipCode("80-235");
		addres.setStreet("Œwietlista");
		addres.setStreetNumber(43);
		
		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
	}

}
