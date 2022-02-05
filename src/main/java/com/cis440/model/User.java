package com.cis440.model;


public class User {

	private int id;

	private String name;

	private String role;

	private String email;

	private String username;

	private String password;

	public User(int id, String name, String role, String email, String username, String password) {
		this.id = id;
		this.name = name;
		this.role = role;
		this.email = email;
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", role='" + role + '\'' +
				", email='" + email + '\'' +
				'}';
	}
}
