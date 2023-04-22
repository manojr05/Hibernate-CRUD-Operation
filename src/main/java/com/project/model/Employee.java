package com.project.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "jecm7")
@NoArgsConstructor
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 50, nullable = false)
	private String name;
	@Lob
	private byte[] video;
	@Column(nullable = false)
	private String city;
	@Column(nullable = false, unique = true)
	private long phone;
	@CreationTimestamp
	private Timestamp creationTime;
	@UpdateTimestamp
	private Timestamp updateTime;

	public Employee(String name, String city, long phone) {
		super();
		this.name = name;
		this.city = city;
		this.phone = phone;
	}

}
