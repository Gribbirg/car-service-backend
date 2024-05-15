package ru.mirea.carservicebackend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * The type App config.
 */
@Configuration
@EnableAsync
public class AppConfig {
}
