package com.cis440.controller;

import com.cis440.model.Post;
import com.cis440.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {

	private PostService postService;

	@Autowired
	public void setPostService(PostService postService) {
		this.postService = postService;
	}

	@GetMapping(value = "/getPost/{id}", produces= "application/json")
	@Operation(summary = "Get Single Post By ID", description = "Returns a single post with given ID")
	public Post getPostById(@PathVariable(value = "id") int id)
	{
		return postService.getPostById(id);
	}

	@GetMapping(value = "/getPosts/parentId/{parentId}", produces= "application/json")
	public List<Post> getPostByParentId(@PathVariable(value = "parentId") int parentId)
	{
		return postService.getPostsByParentId(parentId);
	}

	@GetMapping(value = "/getPosts/ownerId/{ownerId}", produces= "application/json")
	@Operation(summary = "Get All Posts From Owner ID", description = "Returns all posts from a user with given ID")
	public List<Post> getPostsByOwner(@PathVariable(value = "ownerId") int ownerId)
	{
		return postService.getPostByOwnerId(ownerId);
	}

	@GetMapping(value = "/getPosts", produces= "application/json")
	@Operation(summary = "Get All Posts", description = "Returns all posts")
	public List<Post> getPosts() { return postService.getPosts(); }

	@DeleteMapping(value = "/deletePost/{id}", produces = "application/json")
	@Operation(summary = "Delete Post By ID", description = "Does not return anything but instead " +
			"deletes a post by given ID")
	public void deletePost(@PathVariable(value = "id") int id) { postService.deletePost(id); }

	@PutMapping(value = "/updateRating/{id}", produces = "application/json")
	@Operation(summary = "Update Post Rating By ID", description = "Does not return anything but instead " +
			"updates a post's rating by ID. Requires rating to be sent as a request param eg ?rating=2")
	public void deletePost(@PathVariable(value = "id") int id, @RequestParam(value = "rating") int rating)
	{
		postService.updateRating(id, rating);
	}

	@PostMapping(value = "/addPost", produces = "application/json")
	public void deletePost(@RequestBody Post post) { postService.createPost(post); }

}
