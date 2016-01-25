package com.yk.example.service;

import com.yk.example.ApplicationTest;
import com.yk.example.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class UserServiceTest extends ApplicationTest {

    @Autowired
    private UserService userService;

    @Test
    public void testGetUser() throws Exception {
        userService.getUser(2l);
    }


    @Test
    public void testDelete() throws Exception {
        userService.deleteUser(3l);
    }

    @Test
    public void testUpdate() throws Exception {
        User user = new User();
        user.setId(1l);
        user.setTel("22222");
        user.setName("test");
        userService.updateUser(user);
    }
}