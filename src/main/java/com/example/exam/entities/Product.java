package com.example.exam.entities;

import lombok.*;

import javax.persistence.*;

@Table(name = "product")
@Data
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String code;

    private String name;
}
