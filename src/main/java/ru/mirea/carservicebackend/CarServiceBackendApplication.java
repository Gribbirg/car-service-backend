package ru.mirea.carservicebackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "ru.mirea.carservicebackend.repositories")
@EntityScan(basePackages = "ru.mirea.carservicebackend.models")
public class CarServiceBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarServiceBackendApplication.class, args);
    }

}
