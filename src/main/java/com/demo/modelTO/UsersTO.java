package com.demo.modelTO;

public class UsersTO {

	private Integer id;
	private String name;
	private String email;
	private String password;
	private StatusTO status;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public StatusTO getStatus() {
		return status;
	}

	public void setStatus(StatusTO status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "UsersBO [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", status="
				+ status + "]";
	}
	
}
