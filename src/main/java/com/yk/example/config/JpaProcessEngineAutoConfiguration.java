package com.yk.example.config;

import org.activiti.spring.SpringAsyncExecutor;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.activiti.spring.boot.AbstractProcessEngineAutoConfiguration;
import org.activiti.spring.boot.ActivitiProperties;
import org.activiti.spring.boot.DataSourceProcessEngineAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.io.IOException;

/**
 * activiti 只应用于primaryDataSource 所以要配置相应的DataSource，EntityManagerFactory，PlatformTransactionManager
 * Created by yk on 16/3/24.
 */
@Configuration
@AutoConfigureBefore(DataSourceProcessEngineAutoConfiguration.class)
@AutoConfigureAfter(DataSourceAutoConfiguration.class)
public class JpaProcessEngineAutoConfiguration extends org.activiti.spring.boot.JpaProcessEngineAutoConfiguration {


    @Configuration
    @ConditionalOnClass(name= "javax.persistence.EntityManagerFactory")
    @EnableConfigurationProperties(ActivitiProperties.class)
    public static class JpaConfiguration extends AbstractProcessEngineAutoConfiguration {

        @Autowired
        @Qualifier("primaryEntityManagerFactory")
        private EntityManagerFactory entityManagerFactory;

        @Autowired
        @Qualifier("primaryDataSource")
        private DataSource dataSource;

        @Autowired
        @Qualifier("primaryTransactionManager")
        private PlatformTransactionManager transactionManager;

        @Bean
        @ConditionalOnMissingBean
        public PlatformTransactionManager transactionManager() {
            return new JpaTransactionManager(entityManagerFactory);
        }

        @Bean
        @ConditionalOnMissingBean
        public SpringProcessEngineConfiguration springProcessEngineConfiguration(
              SpringAsyncExecutor springAsyncExecutor) throws IOException {

            SpringProcessEngineConfiguration config = this.baseSpringProcessEngineConfiguration(dataSource,
                    transactionManager, springAsyncExecutor);
            config.setJpaEntityManagerFactory(entityManagerFactory);
            config.setTransactionManager(transactionManager);
            config.setJpaHandleTransaction(false);
            config.setJpaCloseEntityManager(false);
            return config;
        }
    }

}
