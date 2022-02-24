package com.cis440.service;

import com.cis440.constant.Department;
import com.cis440.constant.SortOrder;
import com.cis440.model.Post;
import com.cis440.model.request.PostRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAmount;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class PostService {
    List<Post> posts = new ArrayList<>();
    {
        posts.add(new Post(1, "Test Post", -1, "This is the content", 1, 100, LocalDateTime.now().minusHours(5), Department.IT));
        posts.add(new Post(2, "Test Post Child", 1, "This is the content of child", 5, 100, LocalDateTime.now().minusHours(4), Department.HR));
        posts.add(new Post(3, "Test Post Child #2", 1, "This is the content of second child", 2, 100, LocalDateTime.now().minusHours(3), Department.FINANCE));
        posts.add(new Post(4, "Test Post Child of ID 2", 2, "This is the content of post id 2's child", 1, 104, LocalDateTime.now().minusHours(1), Department.MARKETING));
    }

    public void updateRating(int id, int rating){
        posts.stream().filter(p -> p.getId() == id).collect(Collectors.toList()).get(0).setRating(rating);
    }

    public List<Post> getPosts(String sortBy, SortOrder sortOrder)
    {
        if(sortBy != null) {
            boolean reverseSort = sortOrder == SortOrder.DESCENDING || sortOrder == null;
            switch (sortBy) {
                case "rating":  if(reverseSort)
                                    posts.sort((Comparator.comparing(Post::getRating).reversed()));
                                else
                                    posts.sort((Comparator.comparing(Post::getRating)));
                                break;
                case "date": if(reverseSort)
                                posts.sort((Comparator.comparing(Post::getDate).reversed()));
                            else
                                posts.sort((Comparator.comparing(Post::getDate)));
                            break;
            }
        }
        return posts;
    }

    private int computeRandomId(){
        List<Integer> ids = posts.stream().map(Post::getId).collect(Collectors.toList());
        int id = 1;
        while(ids.contains(id))
            id = Math.abs(new Random().nextInt());
        return id;
    }

    public void createPost(PostRequest post){
        Post temp = new Post(computeRandomId(), post.getTitle(), -1, post.getContent(),
                post.getRating(), post.getOwnerId(), LocalDateTime.now(),post.getDepartment() );
        posts.add(temp);
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

    public List<Post> getPostByDepartment(Department department)
    {
        return posts.stream().filter(post -> post.getDepartment() == department).collect(Collectors.toList());
    }

}

