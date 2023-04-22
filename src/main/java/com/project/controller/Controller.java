package com.project.controller;

import java.util.Scanner;
import com.project.service.Service;

public class Controller {
	public static void main(String[] args) throws Exception {
		Service service = new Service();
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		while (flag) {

			System.out.println("\n\nEnter 1 if you want to insert the data into the table: \n"
					+ "Enter 2 to update the name: \n" + "Enter 3 to delete the data: \n"
					+ "Enter 4 to fetch the vedio: \n" + "Enter 5 to fetch all the details except vedio:\n"
					+ "Enter 6 to fetch id and name:\nEnter 7 to exit:\n\n");

			switch (sc.nextInt()) {

			case 1:
				service.add();
				break;
			case 2:
				service.updateNameById();
				break;
			case 3:
				service.removeById();
				break;
			case 4:
				service.fetchVedioById();
				break;
			case 5:
				service.fetchAllTheDetails();
				break;
			case 6:
				service.fetchIdAndName();
				break;
			case 7:
				System.out.println("\n\nThank You");
				flag = false;
				break;
			default:
				System.out.println("\n\nEnter the valid option");
				break;
			}
		}
		sc.close();
	}
}
