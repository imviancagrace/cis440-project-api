package com.cis440.service;

import com.cis440.model.User;
import com.cis440.model.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.FailedLoginException;
import java.util.stream.Collectors;

@Service
public class LoginService {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public User checkLogin(String username, String password) throws FailedLoginException {
        User checkUser = userService.getUsers().stream().filter(u -> u.getUsername().equalsIgnoreCase(username)).collect(Collectors.toList()).get(0);
        if(checkUser.getPassword().equals(password))
            return checkUser;
        else throw new FailedLoginException();
    }

    public User checkLogin(UserLogin userLogin) throws FailedLoginException {
        String username = userLogin.getUsername();
        String password = userLogin.getPassword();
        User checkUser = userService.getUsers().stream().filter(u -> u.getUsername().equalsIgnoreCase(username)).collect(Collectors.toList()).get(0);
        if(checkUser.getPassword().equals(password))
            return checkUser;
        else throw new FailedLoginException();
    }
}
