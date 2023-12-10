package com.tiesch.boot.springboot.service;

import com.tiesch.boot.springboot.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    void addUser(User user);
    User getUser(int id);
    void deleteUser(int id);

}
