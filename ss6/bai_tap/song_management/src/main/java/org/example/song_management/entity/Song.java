package org.example.song_management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


    @Entity
    @Getter
    @Setter
    @Table(name = "songs")
    public class Song extends Parent {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
        private String artist;
        private String genre;
    }

