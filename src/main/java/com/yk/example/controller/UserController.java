package com.yk.example.controller;

import com.yk.example.repository.UserRepository;
import com.yk.example.security.PreAuthorise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yk on 15/12/8.
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "queryByName",method = RequestMethod.GET)
    public Object queryByName(String name) {
        return userRepository.findByName(name);
    }

    @RequestMapping(value = "test",method = RequestMethod.GET)
    public Object helloWorld() {
        return "hello , world";
    }

    @PreAuthorise
    @RequestMapping(value = "test2",method = RequestMethod.GET)
    public Object helloWorld2() {
        return "hello , world";
    }
}
