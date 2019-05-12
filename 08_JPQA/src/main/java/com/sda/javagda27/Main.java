package com.sda.javagda27;

import java.util.Iterator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.sda.javagda27.domain.Employee;

public class Main {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;

	public static void main(String[] args) {
		entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		entityManager = entityManagerFactory.createEntityManager();

		addEmployees();
		// ---- single object ---
//		TypedQuery<Employee> query = entityManager
//				.createQuery("select e from Employee e where e.lastName = 'Krystian' order by e.salary", Employee.class);
//		Employee employee = query.getSingleResult();
//		System.out.println("First name: " + employee.getFirstName());
//		System.out.println("Last name: " + employee.getLastName());
//		System.out.println("Salary: " + employee.getSalary());

		// ---- list of objects -----

//		TypedQuery<Employee> query = entityManager.createQuery("select e from Employee e where e.salary < 5000 order by e.salary", Employee.class);	
//		List<Employee> employees = query.getResultList();
//		
//		for (Employee employee : employees) {
//			System.out.println("First name: " + employee.getFirstName());
//			System.out.println("Last name: " + employee.getLastName());
//			System.out.println("Salary: " + employee.getSalary());
//		}		

		// ----- complex query ----
		Query complexQuery = entityManager
				.createQuery("select concat(e.firstName, ' ' , e.lastName), e.salary * 0.2 from Employee e");	
		Iterator<?> employeesList = complexQuery.getResultList().iterator();
		while (employeesList.hasNext()) {
			Object[] item = (Object[]) employeesList.next();
			String name = (String) item[0];
			double tax = (Double)item[1];
			System.out.println(name + " need to pay " + tax);
		}
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
