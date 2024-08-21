package com.example.exam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExamApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExamApplication.class, args);

        String[] test = "20203,,,,,,".replace(",", ",X").split(",");

        for (String a : test) {
            System.out.println(a);
        }
    }

}
