package test_project;

import javax.persistence.Persistence;

public class Test_Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		var entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		var entityManager = entityManagerFactory.createEntityManager();
		
		
		entityManager.close();
		entityManagerFactory.close();
		
	}

}
