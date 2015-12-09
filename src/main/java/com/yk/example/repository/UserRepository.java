package com.yk.example.repository;

import com.yk.example.entity.User;

/**
 * Created by yk on 15/12/8.
 */
public interface UserRepository extends MyRepository<User,Long> {

    User findByName(String name);
}
