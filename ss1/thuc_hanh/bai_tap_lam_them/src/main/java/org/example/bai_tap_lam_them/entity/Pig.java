package org.example.bai_tap_lam_them.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Pig extends Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate timeIn;
    private Float weightIn;
    private LocalDate timeOut;
    private Float weightOut;
    @ManyToOne
    @JoinColumn(name = "country_id",referencedColumnName ="id" )
    private Country country;
}
