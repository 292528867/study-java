package com.yk.example.repository;

import com.yk.example.ApplicationTest;
import com.yk.example.entity.primary.User;
import com.yk.example.repository.primary.UserRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRepositoryTest extends ApplicationTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testName() throws Exception {
        User user = new User();
        user.setName("test");
        user.setTel("111111111");
        User user1 = userRepository.findByName("test");
        System.out.println(user1.toString());
    }

}