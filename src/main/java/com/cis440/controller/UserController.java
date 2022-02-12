package com.cis440.controller;

import com.cis440.model.User;
import com.cis440.service.UserService;
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

	@GetMapping(value = "/getUsers", produces = "application/json")
	public List<User> getUsers() {
		return userService.getUsers();
	}

	@GetMapping(value = "/getUser/{id}", produces = "application/json")
	public User getUserById(@PathVariable(value = "id") int id) {
		return userService.getUserById(id);
	}

	@GetMapping(value = "/getUser/role/{role}", produces = "application/json")
	public List<User> getUserByRole(@PathVariable(value = "role") String role) {
		return userService.getUserByRole(role);
	}

	@GetMapping(value = "/getPost/id/{id}", produces= "application/json")
	public Post getPostById(@PathVariable(value = "id") int id)
	{
		return userService.getPostById(id);
	}

	@GetMapping(value = "/getPost/parentId/{parentId}", produces= "application/json")
	public Post getPostByParentId(@PathVariable(value = "parentId") int parentId)
	{
		return userService.getPostByParentId(parentId);
	}

	@GetMapping(value = "/getPost/rating/{rating}", produces= "application/json")
	public List<Post> getPostByRating(@PathVariable(value = "rating") int rating)
	{
		return userService.getPostByRating(rating);
	}

	@GetMapping(value = "/getPost/owner/{owner}", produces= "application/json")
	public List<Post> getPostByOwner(@PathVariable(value = "owner") User owner)
	{
		return userService.getPostByOwner(owner);
	}

	@GetMapping(value = "/getPost/title/{title}", produces= "application/json")
	public List<Post> getPostByTitle(@PathVariable(value = "title") String title)
	{
		return userService.getPostByTitle(title);
	}

	@GetMapping(value = "/getPost/content/{content}", produces= "application/json")
	public List<Post> getPostByContent(@PathVariable(value = "content") String content)
	{
		return userService.getPostByContent(content);
	}

}
