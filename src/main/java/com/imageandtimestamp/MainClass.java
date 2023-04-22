package com.imageandtimestamp;

import java.io.FileInputStream;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MainClass {
	public static void main(String[] args) throws Exception {
		EntityManagerFactory ef = Persistence.createEntityManagerFactory("dev");
		EntityManager em = ef.createEntityManager();
		EntityTransaction t = em.getTransaction();

		Image i1 = new Image("Manoj R");

		FileInputStream f = new FileInputStream("C:\\Users\\MR.AK_INDIAN\\Desktop\\Seal\\s1.jpg");
		byte[] b = new byte[f.available()];
		f.read(b);
		i1.setImage(b);

		t.begin();
		em.persist(i1);
		t.commit();
	}
}
