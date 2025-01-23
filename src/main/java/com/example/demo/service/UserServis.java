package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

public interface UserServis {
    public void addUser(User user);
    public List<User> getAllUsers();
    public void removeUserById(Long id);

    public User findUserById(Long id);
}
