package com.yk.example.service;

import com.yk.example.entity.User;
import com.yk.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * Created by yk on 16/1/20.
 */
@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;


    @Cacheable(cacheNames = "userCache",key = "'study:test:user:' + #p0 ")
    public User getUser(long id) {
        return userRepository.findOne(id);
    }
}
