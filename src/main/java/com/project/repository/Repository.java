package com.project.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.project.model.Employee;

public class Repository {

	EntityManagerFactory e = Persistence.createEntityManagerFactory("dev");
	EntityManager m = e.createEntityManager();
	EntityTransaction t = m.getTransaction();

	public void add(Employee e) {
		t.begin();
		m.persist(e);
		t.commit();
	}

	public void update(int id, String name) {
		Employee e = m.find(Employee.class, id);
		if (e != null) {
			e.setName(name);
			t.begin();
			m.persist(e);
			t.commit();
		} else {
			System.err.print("Enter the valid id");
		}
	}

	public void remove(int id) {
		Employee e = m.find(Employee.class, id);
		t.begin();
		m.remove(e);
		t.commit();
	}

	public Employee fetch(int id) {
		Employee e = m.find(Employee.class, id);
		if (e != null) {
			return e;
		} else {
			System.err.println("Enter the valid id");
			return null;
		}
	}

	public List<Employee> fetch() {
		Query q = m.createQuery("select a from jecm7 a");
		List<Employee> resultList = q.getResultList();
		return resultList;
	}
}
