package com.yk.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
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
        basePackages = "com.yk.example.repository.secondary",
        entityManagerFactoryRef = "secondaryEntityManagerFactory",
        transactionManagerRef = "secondaryTransactionManager"
)
public class JpaRepositorySecondaryConfig {

    @Autowired
    @Qualifier("secondaryEntityManagerFactory")
    private EntityManagerFactory entityManagerFactory;

    @Bean
    public PlatformTransactionManager secondaryTransactionManager() {
        return new JpaTransactionManager(entityManagerFactory);
    }

}
