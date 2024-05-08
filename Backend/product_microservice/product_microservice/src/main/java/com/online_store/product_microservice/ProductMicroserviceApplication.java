package com.online_store.product_microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EntityScan("com.online_store.product_microservice.model")
@EnableJpaRepositories(basePackages = "com.online_store.product_microservice.repository")
@PropertySource("file:C:/Users/asemy/OneDrive/Desktop/product_microservice/product_microservice/src/main/resources/application.properties")

@SpringBootApplication
public class ProductMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductMicroserviceApplication.class, args);
	}

}
