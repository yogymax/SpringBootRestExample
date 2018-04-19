package com.scp.spring.boot.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.scp.spring.boot"})
@EnableJpaRepositories("com.scp.spring.boot.service")
@EntityScan("com.scp.spring.boot.entity")
public class BootMyApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMyApplication.class, args);
	}
}
