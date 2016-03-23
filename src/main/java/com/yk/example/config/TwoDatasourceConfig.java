package com.yk.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;

/**
 * Created by yk on 16/3/23.
 */
@Configuration
public class TwoDatasourceConfig {

    @Autowired
    private JpaProperties jpaProperties;


    @Bean
    @Primary
    @ConfigurationProperties(prefix = "datasource.primary")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties(prefix = "datasource.secondary")
    public DataSource secondaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean primaryEntityManagerFactory(
            EntityManagerFactoryBuilder builder) {
        DataSource dataSource = primaryDataSource();
        System.out.println("datasource---------"+dataSource);
        return builder.dataSource(dataSource)
                .packages("com.yk.example.entity.primary")
                .properties(jpaProperties.getHibernateProperties(dataSource))
                .build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean secondaryEntityManagerFactory(
            EntityManagerFactoryBuilder builder) {
        DataSource dataSource = secondaryDataSource();
        System.out.println("datasource---------"+dataSource);
        return builder.dataSource(dataSource)
                .packages("com.yk.example.entity.secondary")
                .properties(jpaProperties.getHibernateProperties(dataSource))
                .build();
    }

}
