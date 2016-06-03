package com.yk.example.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.wordnik.swagger.annotations.ApiOperation;
import com.yk.example.entity.primary.User;
import com.yk.example.repository.primary.UserRepository;
import com.yk.example.security.PreAuthorise;
import com.yk.example.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


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
        //TODO redis 缓存时 objectMapper writer 报错 没有provider 所有缓存时不用jackson序列化
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

    /**
     * 查询所有的用户按name排序
     * @return
     */
    @RequestMapping(value = "findAllOrderByName",method = RequestMethod.GET)
    @ApiOperation(value = "查询所有的用户按name排序",response = List.class)
    public Object findAllOrderByName() {
        List<User> userList = userService.findAllOrderByName();
        SimpleFilterProvider provider = new SimpleFilterProvider();
        provider.addFilter("user", SimpleBeanPropertyFilter.serializeAllExcept("remark", "roles"));
        provider.addFilter("role", SimpleBeanPropertyFilter.serializeAllExcept("id"));
        try {
            return objectMapper.writer(provider).writeValueAsString(userList);
        } catch (JsonProcessingException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public Object helloWorld1() {
//        testException();
        List<User> users = userService.testMoreTableRelation();
        SimpleFilterProvider provider = new SimpleFilterProvider();
        provider.addFilter("user", SimpleBeanPropertyFilter.serializeAllExcept("remark", "roles"));
        provider.addFilter("role", SimpleBeanPropertyFilter.serializeAllExcept("id"));
        try {
            return objectMapper.writer(provider).writeValueAsString(users);
        } catch (JsonProcessingException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return null;
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
