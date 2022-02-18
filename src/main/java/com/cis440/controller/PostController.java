package com.cis440.controller;

import com.cis440.model.Post;
import com.cis440.service.PostService;
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
	public List<Post> getPostsByOwner(@PathVariable(value = "ownerId") int ownerId)
	{
		return postService.getPostByOwnerId(ownerId);
	}

	@GetMapping(value = "/getPosts", produces= "application/json")
	public List<Post> getPosts() { return postService.getPosts(); }

	@DeleteMapping(value = "/deletePost/{id}", produces = "application/json")
	public void deletePost(@PathVariable(value = "id") int id) { postService.deletePost(id); }

	@PutMapping(value = "/updateRating/{id}", produces = "application/json")
	public void deletePost(@PathVariable(value = "id") int id, @RequestParam(value = "rating") int rating) { postService.updateRating(id, rating); }

	@PostMapping(value = "/addPost", produces = "application/json")
	public void deletePost(@RequestBody Post post) { postService.createPost(post); }

}
