package com.yk.example.controller;

import com.yk.example.elasticsearch.Customer;
import com.yk.example.elasticsearch.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yk on 15/12/9.
 */
@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping(value = "saveCustomer",method = RequestMethod.POST)
    public Object saveCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @RequestMapping(value = "fetchAllCustomers",method = RequestMethod.GET)
    public Object fetchAllCustomers() {
        return customerRepository.findAll();
    }
}
