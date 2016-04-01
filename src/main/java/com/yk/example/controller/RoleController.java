package com.yk.example.controller;

import com.wordnik.swagger.annotations.ApiOperation;
import com.yk.example.repository.primary.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yk on 16/4/1.
 */
@RestController
@RequestMapping("role")
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "查询所有角色",notes = "查询所有角色")
    public Object queryAll() {
        return roleRepository.findAll();
    }

}
