package com.cis440.service;

import com.cis440.constant.Department;
import com.cis440.model.User;
import com.cis440.model.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    List<User> users = new ArrayList<>();
    {
        users.add(new User(100,"TechGeekNext-User1", "ADMIN", Department.IT, "user1@test.com", "test", "test12"));
        users.add(new User(101,"TechGeekNext-User2", "SUPERVISOR",Department.IT, "user2@test.com", "test1", "test12"));
        users.add(new User(103,"TechGeekNext-User3", "USER",Department.IT, "user3@test.com", "test2", "test12"));
        users.add(new User(104,"TechGeekNext-User4", "USER",Department.IT, "user4@test.com", "test3", "test12"));
    }

    public List<User> getUsers(){
        return users;
    }

    public User getUserById(int id){
        return users.stream().filter(user -> user.getId() == id).collect(Collectors.toList()).get(0);
    }

    public List<User> getUserByRole(String role){
        return users.stream().filter(user -> user.getRole().equalsIgnoreCase(role)).collect(Collectors.toList());

    }
}

