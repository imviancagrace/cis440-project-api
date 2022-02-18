package com.cis440.service;

import com.cis440.model.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class PostService {
    List<Post> posts = new ArrayList<>();
    {
        posts.add(new Post(1, "Test Post", -1, "This is the content", 1, 100));
        posts.add(new Post(2, "Test Post Child", 1, "This is the content of child", 1, 100));
        posts.add(new Post(3, "Test Post Child #2", 1, "This is the content of second child", 1, 100));
        posts.add(new Post(4, "Test Post Child of ID 2", 2, "This is the content of post id 2's child", 1, 104));
    }

    public void updateRating(int id, int rating){
        posts.stream().filter(p -> p.getId() == id).collect(Collectors.toList()).get(0).setRating(rating);
    }

    public List<Post> getPosts()
    {
        return posts;
    }

    public void deletePost(int id){
        posts.removeIf(p -> p.getId() == id);
    }

    public Post getPostById(int id)
    {
        return posts.stream().filter(post -> post.getId() == id).collect(Collectors.toList()).get(0);
    }

    public List<Post> getPostsByParentId(int parentId)
    {
        return posts.stream().filter(post -> post.getParentId() == parentId).collect(Collectors.toList());
    }

    public List<Post> getPostByOwnerId(int ownerId)
    {
        return posts.stream().filter(post -> post.getOwnerId() == ownerId).collect(Collectors.toList());
    }

}

