package com.project.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Scanner;
import com.aes.AES;
import com.project.model.Employee;
import com.project.repository.Repository;

public class Service {

	Repository repository = new Repository();
	Scanner sc = new Scanner(System.in);
	Scanner sc1 = new Scanner(System.in);

	public void add() throws Exception {
		Employee e = new Employee();
		System.out.print("\n\nEnter the name:");
		e.setName(sc1.nextLine());
		System.out.print("Enter the city:");
		e.setCity(AES.encrypt(sc.next(), "123"));
		System.out.print("Enter the Phone Number:");
		e.setPhone(sc.nextLong());
		System.out.print("Enter the name of the video file to be inserted:");
		String str = "C:\\Users\\MR.AK_INDIAN\\Desktop\\HibernateProject\\InputVideo\\" + sc.next() + ".mp4";
		FileInputStream f = new FileInputStream(str);
		byte[] b = new byte[f.available()];
		f.read(b);
		e.setVideo(b);
		repository.add(e);
		f.close();
		System.out.print("1 record added");
	}

	public void updateNameById() {
		System.out.print("\n\nEnter the id:");
		int id = sc.nextInt();
		System.out.print("Enter the updated name:");
		String name = sc1.nextLine();
		repository.update(id, name);
		System.out.print("name updated");
	}

	public void removeById() {
		System.out.print("\n\nEnter the id of which data has to be removed:");
		repository.remove(sc.nextInt());
		System.out.print("1 record deleted");
	}

	public void fetchVedioById() throws Exception {
		System.out.print("\n\nEnter the ID:");
		Employee e = repository.fetch(sc.nextInt());
		String str = "C:\\Users\\MR.AK_INDIAN\\Desktop\\HibernateProject\\OutputVideo\\V" + e.getId() + ".mp4";
		FileOutputStream f = new FileOutputStream(str);
		f.write(e.getVideo());
	}

	public void fetchAllTheDetails() {
		List<Employee> list = repository.fetch();
		System.out.print("\n\n");
		System.out.printf("%s\t%-20s\t%-20s\t%s\t%-25s\t%-20s\n", "id", "name", "city", "phone no", "creation timestamp", "update timestamp");
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
		for (Employee e : list) {
			System.out.printf("%d\t%-20s\t%-20s\t%d\t%-25s\t%-20s\n", e.getId(), e.getName(), AES.decrypt(e.getCity(), "123"),
					e.getPhone(), e.getCreationTime(), e.getUpdateTime());
		}
	}

	public void fetchIdAndName() {
		List<Employee> list = repository.fetch();
		System.out.print("\n\n");
		System.out.printf("%s\t%-10s\n", "id", "name");		
		System.out.println("--------------------------");
		for (Employee e : list) {
			System.out.printf("%d\t%-10s\n", e.getId(), e.getName());
		}
	}

}
