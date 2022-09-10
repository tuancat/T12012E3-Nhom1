package com.sam.lab4.service;

import com.sam.lab4.model.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUser();
    public void addUser(User user);
    public void updateUser(User user);
    public void deleteUser(User user);
}
