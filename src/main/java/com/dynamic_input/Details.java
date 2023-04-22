package com.dynamic_input;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "details")
public class Details {
	
	@Id
	private Integer id;
	
	@Column(name = "name", nullable = false, length = 50)
	private String name;
	
	@Column(name = "city", length = 50)
	private String city;
	
	@Column(name="phone_number", unique = true)
	private Long phone;
}
