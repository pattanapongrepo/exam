package com.example.exam.service;

import com.example.exam.dto.ProductDto;
import com.example.exam.entities.Product;
import com.example.exam.repo.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;
    @InjectMocks
    private ProductService productService;

    private Product product;

    private ProductDto productDto;

    @BeforeEach
    public void setup() {
        product = Product.builder().id(99).code("999").name("Ae").build();
        productDto = ProductDto.builder().id(99).code("999").name("Ae").build();
        System.out.println("Before data :" + product.toString());
    }

    @Test
    @DisplayName("test_getAll")
    void test_getAll() {
        //given
        Product product1 = Product.builder().id(99).code("999").name("Ae").build();
        given(productRepository.findAll()).willReturn(List.of(product, product1));

        //when
        List<Product> productList = productService.getAll();

        //then
        assertThat(productList.size()).isEqualTo(2);
        assertThat(productList.get(0).getCode()).isEqualTo("12345");
        assertThat(productList.get(1).getCode()).isEqualTo("12345");
    }

    @Test
    @DisplayName("test_getAllDto")
    void test_getAllDto() {
        //given
        ProductDto productDto1 = ProductDto.builder().id(100).code("1000").name("Ae+").build();
        given(productRepository.findAllDto()).willReturn(List.of(productDto, productDto1));

        //when
        List<ProductDto> productList = productService.getAllDto();

        //then
        assertThat(productList.size()).isEqualTo(2);
        assertThat(productList.get(0).getCode()).isEqualTo("12345");
        assertThat(productList.get(1).getCode()).isEqualTo("12345");
    }

    @Test
    @DisplayName("test_findProduct")
    void test_findProduct() {
        //given
        given(productRepository.findById(product.getId())).willReturn(Optional.of(product));

        //when
        Product rs = productService.findProduct(product);

        //then
        assertThat(rs.getId()).isEqualTo(99);
        assertThat(rs.getCode()).isEqualTo("999");
        assertThat(rs.getName()).isEqualTo("Ae");
    }
}