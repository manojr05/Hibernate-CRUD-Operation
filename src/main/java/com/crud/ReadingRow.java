package com.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ReadingRow {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager m = emf.createEntityManager();
//		EntityTransaction t = m.getTransaction();
		
		Employee e = m.find(Employee.class, 1);
		if (e != null) {
			System.out.printf("%d\t%-10s\t%-10s\t%d\t%10.2f\n", e.getId(), e.getName(), e.getCity(), e.getAge(), e.getSalary());
		} else {
			System.out.println("No Data Found on the given ID");
		}
	}
}
