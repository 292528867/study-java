package com.yk.example.config;

import com.yk.example.repository.MyRepositoryImp;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by yk on 15/12/8.
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.yk.example",
         repositoryBaseClass = MyRepositoryImp.class)
public class JpaConfig {


}
