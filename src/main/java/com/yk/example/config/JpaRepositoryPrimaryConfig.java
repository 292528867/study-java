package com.yk.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;

/**
 * Created by yk on 16/3/23.
 */
@Configuration
@EnableJpaRepositories(
        basePackages = "com.yk.example.repository.primary",
        entityManagerFactoryRef = "primaryEntityManagerFactory",
        transactionManagerRef = "primaryTransactionManager"
)
public class JpaRepositoryPrimaryConfig {

    @Autowired
    @Qualifier("primaryEntityManagerFactory")
    private EntityManagerFactory entityManagerFactory;

    @Bean
    public PlatformTransactionManager primaryTransactionManager() {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
