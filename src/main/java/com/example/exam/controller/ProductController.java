package com.example.exam.controller;

import com.example.exam.dto.ProductDto;
import com.example.exam.entities.Product;
import com.example.exam.entities.User;
import com.example.exam.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        List<Product> response = productService.getAll();
        if (response.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/product/dto")
    public ResponseEntity<List<ProductDto>> getAllDto() {
        List<ProductDto> response = productService.getAllDto();
        if (response.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public static void main(String[] args) {

        Optional<User> user = getUser("TOM");

        User a =  user.orElse(new User(1,"1",1));

        System.out.println(a);
    }

    private static Optional<User> getUser(String name){
        User user = new User(1,name,1);
        return Optional.of(user);
    }

    @GetMapping("/test")
    public String getTest(){
        return "a";
    }
}
