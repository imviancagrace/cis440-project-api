package com.cis440.model;

import com.cis440.constant.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class User {

	private int id;
	private String name;
	private String role;
	private Department department;
	private String email;
	private String username;
	private String password;

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
