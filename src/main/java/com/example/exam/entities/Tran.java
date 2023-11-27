package com.example.exam.entities;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Table(name = "tran")
@Data
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Tran {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Integer user;

    private Integer product;

    private Integer amount;

    @CreationTimestamp
    private Date created;
}
