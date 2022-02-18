package com.cis440.controller;

import com.cis440.model.User;
import com.cis440.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@GetMapping(value = "/users", produces = "application/json")
	@Operation(summary = "Get All Users", description = "Returns a list of all users")
	public List<User> getUsers() {
		return userService.getUsers();
	}

	@GetMapping(value = "/user/{id}", produces = "application/json")
	@Operation(summary = "Get Single User By ID", description = "Returns a single user with given ID")
	public User getUserById(@PathVariable(value = "id") int id) {
		return userService.getUserById(id);
	}

	@GetMapping(value = "/user/role/{role}", produces = "application/json")
	@Operation(summary = "Get Single Users By Role", description = "Returns all users under a given role")
	public List<User> getUserByRole(@PathVariable(value = "role") String role) {
		return userService.getUserByRole(role);
	}
}
