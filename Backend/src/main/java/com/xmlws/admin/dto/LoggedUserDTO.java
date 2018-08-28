package com.xmlws.admin.dto;

public class LoggedUserDTO {

	private String email;
	private String role;
	private long id;
	
	public LoggedUserDTO() {
		
	}
	
	public LoggedUserDTO(String email, String role, long id) {
		this.email = email;
		this.role = role;
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
}
