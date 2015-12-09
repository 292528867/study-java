package com.yk.example.elasticsearch;


import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * Created by yk on 15/12/9.
 */
public interface CustomerRepository extends ElasticsearchRepository<Customer,Long> {

    public Customer findByName(String name);

    public List<Customer> findByLastName(String lastName);
}
