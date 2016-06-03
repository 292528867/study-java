package com.yk.example.service;

import com.yk.example.entity.primary.User;
import com.yk.example.repository.primary.UserRepository;
import com.yk.example.repository.secondary.UserSecondaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by yk on 16/1/20.
 */
@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserSecondaryRepository userSecondaryRepository;


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
     *
     * @param user
     * @return
     */
    @CachePut(value = "userCache", key = "'study:test:user:'+ #user.id")
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Cacheable(value = "userTokenCache", key = "'study:test:user:token:' + #p0 ")
    public User findByToken(String token) {
        return userRepository.findByToken(token);
    }

    @Cacheable(value = "findAllOrderByName", key = "'study:test:user:all:orderByName'")
    public List<User> findAllOrderByName() {
        return userRepository.findAllOrderByName();
    }

    /**
     * 测试多表关联
     *
     * @return
     */
    public List<User> testMoreTableRelation() {
        return userRepository.findUserRelationByTel();
    }

    public void testTwoDatasource() {
        System.out.println(userRepository.findAll());
        System.out.println(userSecondaryRepository.findAll());
    }

    public void testException(String name) {
        if (name == null || "".equals(name)) {
            throw new NullPointerException();
        }
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

}
