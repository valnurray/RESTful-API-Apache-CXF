package com.lankin.RESTfullSeviceApacheCXF;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableTransactionManagement
@ComponentScan(basePackages = "com")
@EntityScan(basePackages = "com.lankin.RESTfullSeviceApacheCXF.model")
@EnableJpaRepositories(basePackages = "com.lankin.RESTfullSeviceApacheCXF.repository")
public class ResTfullSeviceApacheCxfApplication {
	public static void main(String[] args) {
		SpringApplication.run(ResTfullSeviceApacheCxfApplication.class, args);
	}
}
