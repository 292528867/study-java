package com.yk.example.service;

import com.yk.example.entity.primary.User;
import com.yk.example.repository.primary.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by yk on 16/1/20.
 */
@Component
public class UserService {

    @Autowired
    @Resource()
    private UserRepository userRepository;


    @Cacheable(cacheNames = "userCache", key = "'study:test:user:' + #p0 ")
    public User getUser(long id) {
        return userRepository.findOne(id);
    }

    /**
     * 删除缓存和数据库中的数据
     *
     * @param id
     */
    @CacheEvict(value = "userCache", key = "'study:test:user:' + #p0 ")
    public void deleteUser(long id) {
        userRepository.delete(id);
    }


    /**
     * 修改缓存和数据库中的数据
     * @param user
     * @return
     */
    @CachePut(value = "userCache", key = "'study:test:user:'+ #user.id")
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Cacheable(value = "userTokenCache",key = "'study:test:user:token:' + #p0 ")
    public User findByToken(String token) {
        return userRepository.findByToken(token);
    }

    public void testException(String name) {
        if (name == null || "".equals(name)) {
            throw new NullPointerException();
        }
    }

}
