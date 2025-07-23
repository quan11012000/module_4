package org.example.form_dang_ky;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class FormDangKyApplication {

    public static void main(String[] args) {
        SpringApplication.run(FormDangKyApplication.class, args);
    }

}
