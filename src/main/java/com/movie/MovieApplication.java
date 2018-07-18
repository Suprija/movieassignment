package com.movie;




import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories(basePackages = "com")
@SpringBootApplication
public class MovieApplication extends SpringBootServletInitializer {
	

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MovieApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(MovieApplication.class, args);
    }
}
