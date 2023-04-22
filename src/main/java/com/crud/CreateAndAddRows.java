package com.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CreateAndAddRows {

	public static void main(String[] args) {
		
		EntityManagerFactory ef=Persistence.createEntityManagerFactory("dev");
		EntityManager em=ef.createEntityManager();
		EntityTransaction t=em.getTransaction();
		
		Employee e1 = new Employee(1, "Manoj R", "Bengaluru", 45000d, 21);
		Employee e2 = new Employee(2, "Durgesh R", "Mangalore", 54000d, 34);
		
		t.begin();
		em.persist(e1);
		em.persist(e2);
		t.commit();

	}

}
