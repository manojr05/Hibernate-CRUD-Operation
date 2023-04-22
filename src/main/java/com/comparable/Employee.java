package com.comparable;

public class Employee implements Comparable {

	private String name;
	private int age;
	private double salary;

	public Employee(String name, int age, double salary) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", salary=" + salary + "]";
	}

	public int compareTo(Object o) {
		Employee e=(Employee)o;
		return this.age-e.age;
	}

	

	

}
