package com.yk.example.repository.primary;

import com.yk.example.entity.primary.User;
import com.yk.example.repository.MyRepository;

/**
 * Created by yk on 15/12/8.
 */
public interface UserRepository extends MyRepository<User,Long> {

    User findByName(String name);

    User findByToken(String token);
}
