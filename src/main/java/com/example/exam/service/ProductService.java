package com.example.exam.service;

import com.example.exam.dto.ProductDto;
import com.example.exam.entities.Product;
import com.example.exam.repo.ProductRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Transactional(readOnly = true)
    public List<Product> getAll() {
        List<Product> rs = productRepository.findAll();
        rs.forEach(v -> v.setCode("12345"));
        return rs;
    }

    @Transactional
    public List<ProductDto> getAllDto() {
        List<ProductDto> rs = productRepository.findAllDto();
        rs.forEach(v -> v.setCode("12345"));
        return rs;
    }

    @Transactional
    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    @Transactional(readOnly = true)
    public Product findProduct(Product product) {
        return productRepository.findById(product.getId()).orElse(null);
    }


    @Transactional
    public void deleteProduct(Product product) {
        productRepository.deleteById(product.getId());
    }
}
