package org.example.song_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SongManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(SongManagementApplication.class, args);
    }

}
