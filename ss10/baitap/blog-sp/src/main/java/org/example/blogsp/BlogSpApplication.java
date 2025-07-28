package org.example.blogsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BlogSpApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogSpApplication.class, args);
    }

}
