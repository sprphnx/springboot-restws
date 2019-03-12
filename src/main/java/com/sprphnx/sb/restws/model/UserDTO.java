package com.sprphnx.sb.restws.model;

import java.util.Date;

public class UserDTO {

	private Integer id;
	private String name;
	private Date dateOfBirth;
	
	public UserDTO() {
		
	}

	public UserDTO(Integer id, String name, Date dateOfBirth) {
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
}
