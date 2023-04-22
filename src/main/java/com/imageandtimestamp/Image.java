package com.imageandtimestamp;

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

@Entity
@Data
public class Image {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 50, nullable = false)
	private String name;
	@CreationTimestamp
	private Timestamp itime;
	@UpdateTimestamp
	private Timestamp utime;
	@Lob
	private byte[] image;

	public Image(String name) {
		super();
		this.name = name;
	}

}
