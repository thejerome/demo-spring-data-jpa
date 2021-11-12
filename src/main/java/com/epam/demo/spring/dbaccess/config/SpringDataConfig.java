package com.epam.demo.spring.dbaccess.config;

import com.epam.demo.spring.dbaccess.repo.UserRepo;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@Import(JpaConfig.class)
@EnableJpaRepositories(basePackages = "com.epam.demo.spring.dbaccess.repo")
public class SpringDataConfig {

}
