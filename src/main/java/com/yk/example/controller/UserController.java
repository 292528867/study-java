package com.yk.example.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.wordnik.swagger.annotations.ApiOperation;
import com.yk.example.entity.primary.User;
import com.yk.example.security.PreAuthorise;
import com.yk.example.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by yk on 15/12/8.
 */
@RestController
@RequestMapping("user")
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    @RequestMapping(value = "queryByName", method = RequestMethod.GET)
    @ApiOperation(value = "查询用户", response = User.class, notes = "query User by name")
    public Object queryByName(String name) {
        System.out.println("test........");
        User user = userService.findByToken(name);
        //过滤掉user中的remark token role实体中的id
        SimpleFilterProvider provider = new SimpleFilterProvider();
        provider.addFilter("user", SimpleBeanPropertyFilter.serializeAllExcept("remark", "token"));
        provider.addFilter("role", SimpleBeanPropertyFilter.serializeAllExcept("id"));
        try {
            return objectMapper.writer(provider).writeValueAsString(user);
        } catch (JsonProcessingException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "createUser", method = RequestMethod.POST)
    @ApiOperation(value = "创建用户", response = User.class, notes = "创建用户")
    public Object createUser(@RequestBody User user) {

        return userService.createUser(user);
    }

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public Object helloWorld(String name) {
        userService.testException(name);
        return "hello , world";
    }

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public Object helloWorld1() {
        testException();
        return "hello , world";
    }

    @PreAuthorise
    @RequestMapping(value = "test2", method = RequestMethod.GET)
    public Object helloWorld2() {
        return "hello , world";
    }

    private void testException() {
        String s = null;
        try {
            s.toString();
        } catch (NullPointerException e) {
            throw new NullPointerException();
        }
    }
}
