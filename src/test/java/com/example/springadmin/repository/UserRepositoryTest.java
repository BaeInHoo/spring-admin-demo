package com.example.springadmin.repository;

import com.example.springadmin.SpringAdminApplicationTests;
import com.example.springadmin.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.springadmin.repository.UserRepository;

import java.time.LocalDateTime;

public class UserRepositoryTest extends SpringAdminApplicationTests {

    @Autowired
    private UserRepository userRepository;

    public void create() {
        User user = new User();
        user.setAccount("TestUser01");
        user.setEmail("TestUser01@gmail.com");
        user.setPhoneNumber("010-1111-1111");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("TestUser01 admin");

    }

    public void read() {

    }

    public void update() {

    }

    public void delete() {

    }
}
