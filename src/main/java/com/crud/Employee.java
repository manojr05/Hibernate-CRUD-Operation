package com.crud;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "emp")
@Getter
@Setter
@NoArgsConstructor
public class Employee {

	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "city")
	private String city;
	@Column(name = "sal")
	private double salary;
	@Column(name = "age")
	private int age;

	public Employee(int id, String name, String city, double salary, int age) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.salary = salary;
		this.age = age;
	}

}
