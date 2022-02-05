package com.cis440.service;

import com.cis440.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    List<User> users = new ArrayList<>();
    {
        users.add(new User(1,"TechGeekNext-User1", "ADMIN", "user1@test.com", "test", "test12"));
        users.add(new User(2,"TechGeekNext-User2", "SUPERVISOR", "user2@test.com", "test1", "test12"));
        users.add(new User(3,"TechGeekNext-User3", "USER", "user3@test.com", "test2", "test12"));
        users.add(new User(4,"TechGeekNext-User4", "USER", "user4@test.com", "test3", "test12"));
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
