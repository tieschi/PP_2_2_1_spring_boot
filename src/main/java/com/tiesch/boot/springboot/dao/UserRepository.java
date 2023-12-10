package com.tiesch.boot.springboot.dao;

import com.tiesch.boot.springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

//    List<User> getAllUsers();
//    void addUser(User user);
//    User getUser(int id);
//    void deleteUser(int id);

}
