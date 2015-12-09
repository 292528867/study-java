package com.yk.example.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.io.Serializable;

/**
 * Created by yk on 15/12/8.
 */
@NoRepositoryBean
public interface MyRepository<T,ID extends Serializable> extends Repository<T,ID> {
    T findOne(ID id);
}
