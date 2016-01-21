package com.yk.example.service;

import com.yk.example.ApplicationTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class RoleServiceTest extends ApplicationTest {

    @Autowired
    private RoleService roleService;

    @Test
    public void testGetRole() throws Exception {
        roleService.getRole();
    }
}