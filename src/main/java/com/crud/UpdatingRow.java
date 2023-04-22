package com.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdatingRow {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager m = emf.createEntityManager();
		EntityTransaction t = m.getTransaction();

		Employee e = m.find(Employee.class, 2);
		if (e != null) {
			t.begin();
			e.setSalary(10000);
			e.setAge(25);
			e.setName("Vaibhav Rendale");
			e.setCity("Examba");
			m.merge(e);
			t.commit();
		} else {
			System.out.println("No Data Found on the given ID");
		}
	}
}
