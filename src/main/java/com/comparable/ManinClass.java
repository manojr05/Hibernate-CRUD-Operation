package com.comparable;

import java.util.Arrays;

public class ManinClass {
	public static void main(String[] args) {
		Employee e1=new Employee("Manoj", 21, 45000);
		Employee e2=new Employee("Rohith", 18, 50000);
		Employee e3=new Employee("Vaibhav", 24, 60000);
		
		Object[] arr= {e1,e2,e3};
		Arrays.sort(arr);
		for (Object o : arr) {
			System.out.println(o);
		}
		
	}
}
