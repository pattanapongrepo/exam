package com.example.exam.repo;

import com.example.exam.dto.ProductDto;
import com.example.exam.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    @Query("""
            SELECT new com.example.exam.dto.ProductDto(p.id,p.code,p.name) FROM Product p
            """)
    List<ProductDto> findAllDto();
}
