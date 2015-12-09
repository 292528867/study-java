package com.yk.example.repository;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * Created by yk on 15/12/8.
 */
public  class MyRepositoryImp<T,ID extends Serializable>
        extends SimpleJpaRepository<T,ID> implements MyRepository<T,ID> {

    private final EntityManager entityManager;

    public MyRepositoryImp(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }
}
