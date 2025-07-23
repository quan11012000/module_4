package org.example.dang_ky.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class User extends Parent{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;     // Họ

    @Column(name = "last_name")
    private String lastName;      // Tên

    @Column(name = "phone_number")
    private String phoneNumber;   // Số điện thoại

    @Column(name = "age")
    private int age;              // Tuổi

    @Column(name = "email")
    private String email;
}
