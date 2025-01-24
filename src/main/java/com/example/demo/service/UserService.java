package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

public interface UserService {
    public void addUser(User user);
    public List<User> getAllUsers();
    public void removeUserById(Long id);
    public void updateUser(User user);
    public User findUserById(Long id);
}
