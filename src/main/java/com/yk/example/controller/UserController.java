package com.yk.example.controller;

import com.wordnik.swagger.annotations.ApiOperation;
import com.yk.example.entity.primary.User;
import com.yk.example.security.PreAuthorise;
import com.yk.example.service.UserService;
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
    private UserService userService;

    @RequestMapping(value = "queryByName",method = RequestMethod.GET)
    @ApiOperation(value = "查询用户",response = User.class,notes = "query User by name")
    public Object queryByName(String name) {
        return userService.findByToken(name);
    }

    @RequestMapping(value = "test",method = RequestMethod.GET)
    public Object helloWorld(String name) {
        userService.testException(name);
        return "hello , world";
    }

    @PreAuthorise
    @RequestMapping(value = "test2",method = RequestMethod.GET)
    public Object helloWorld2() {
        return "hello , world";
    }
}
