package org.example.dang_ky;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DangKyApplication {

    public static void main(String[] args) {
        SpringApplication.run(DangKyApplication.class, args);
    }

}
