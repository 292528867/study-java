package com.yk.example.service;

import com.yk.example.entity.primary.Role;
import com.yk.example.repository.primary.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by yk on 16/1/20.
 */
@Component
public class RoleService  {

    @Autowired
    private RoleRepository roleRepository;

    @Cacheable(cacheNames = "roleCache" ,key = "'study:test:role:all'")
    public List<Role> getRole() {
        return roleRepository.findAll();
    }
}
