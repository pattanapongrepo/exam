package com.example.exam.entities;

import lombok.*;

import javax.persistence.*;

@Table(name = "user")
@Data
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private Integer age;
}
