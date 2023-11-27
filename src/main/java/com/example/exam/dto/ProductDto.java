package com.example.exam.dto;

import lombok.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {
    private Integer id;
    private String code;
    private String name;
}
