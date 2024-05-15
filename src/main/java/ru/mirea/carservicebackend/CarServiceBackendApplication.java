package ru.mirea.carservicebackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * The type Car service backend application.
 */
@SpringBootApplication
@EnableJpaRepositories(basePackages = "ru.mirea.carservicebackend.repositories")
@EntityScan(basePackages = "ru.mirea.carservicebackend.models")
public class CarServiceBackendApplication {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(CarServiceBackendApplication.class, args);
    }

}
