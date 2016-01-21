package com.yk.example.service;

import com.yk.example.ApplicationTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class UserServiceTest extends ApplicationTest {

    @Autowired
    private UserService userService;

    @Test
    public void testGetUser() throws Exception {
        userService.getUser(1l);
    }
}