package com.dynamic_input;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.boot.model.source.internal.hbm.CompositeIdentifierSingularAttributeSourceManyToOneImpl;

public class ManiClass {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Details d1 = new Details();

		boolean flag = true;
		while (flag) {
			System.out.println(
					"\n\nEnter 0 to save the changes:\n" + "Enter 1 if you want to insert the data into the table: \n"
							+ "Enter 2 to update the city: \n" + "Enter 3 to delete the details: \n"
							+ "Enter 4 to fetch the particular details: \n" + "Enter 5 to commit and exit:\n");
			int x = sc.nextInt();
			switch (x) {

			case 0:
				transaction.commit();
				System.out.println("changes committed....");
				break;

			case 1:
				Scanner sc1 = new Scanner(System.in);

				System.out.print("Enter the id:");
				d1.setId(sc.nextInt());

				System.out.print("Enter the name:");
				d1.setName(sc1.nextLine());

				System.out.print("Enter the city:");
				d1.setCity(sc.next());

				System.out.print("Enter the phone_number:");
				d1.setPhone(sc.nextLong());

				entityManager.persist(d1);
				break;

			case 2:
				System.out.print("Enter the row for which the city to be changed:");
				Details d2 = entityManager.find(Details.class, sc.nextInt());
				System.out.print("Enter the city:");
				d2.setCity(sc.next());
				entityManager.merge(d2);
				break;

			case 3:
				System.out.print("Enter the row to be deleted:");
				Details e3 = entityManager.find(Details.class, sc.nextInt());
				entityManager.remove(e3);
				break;

			case 4:
				System.out.print("Enter the id to be displayed:");
				Details e4 = entityManager.find(Details.class, sc.nextInt());
				System.out.printf("\n\n%d\t%-10s\t%-10s\t%d\n", e4.getId(), e4.getName(), e4.getCity(), e4.getPhone());
				break;

			case 5:
				transaction.commit();
				flag = false;
				System.out.println("thanks for using the application.....");
				break;

			default:
				System.out.println("please enter the valid option...");
				break;

			}
		}

	}
}
