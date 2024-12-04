package com.example.orderbackend.infra.repository;

import com.example.orderbackend.domain.model.Product;
import com.example.orderbackend.domain.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import(ProductRepositoryImpl.class)
class ProductRepositoryImplTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void whenSaveProduct_thenProductIsPersisted() {
        // Given
        Product product = new Product();
        product.setName("Test Product");
        product.setDescription("This is a test product");
        product.setPrice(9.99);

        // When
        Product savedProduct = productRepository.save(product);

        // Then
        assertThat(savedProduct.getId()).isNotNull();
        assertThat(savedProduct.getName()).isEqualTo("Test Product");
        assertThat(savedProduct.getDescription()).isEqualTo("This is a test product");
        assertThat(savedProduct.getPrice()).isEqualTo(9.99);
    }

    @Test
    void whenFindById_thenReturnProduct() {
        // Given
        Product product = new Product();
        product.setName("Another Product");
        product.setDescription("This is another test product");
        product.setPrice(19.99);
        Product savedProduct = productRepository.save(product);

        // When
        Optional<Product> foundProduct = productRepository.findById(savedProduct.getId());

        // Then
        assertThat(foundProduct).isPresent();
        assertThat(foundProduct.get().getName()).isEqualTo("Another Product");
        assertThat(foundProduct.get().getDescription()).isEqualTo("This is another test product");
        assertThat(foundProduct.get().getPrice()).isEqualTo(19.99);
    }

    @Test
    void whenFindAll_thenReturnAllProducts() {
        // Given
        Product product1 = new Product();
        product1.setName("Product 1");
        product1.setPrice(10.0);
        productRepository.save(product1);

        Product product2 = new Product();
        product2.setName("Product 2");
        product2.setPrice(20.0);
        productRepository.save(product2);

        // When
        List<Product> products = productRepository.findAll();

        // Then
        assertThat(products).hasSize(2);
        assertThat(products).extracting(Product::getName).containsExactlyInAnyOrder("Product 1", "Product 2");
    }

    @Test
    void whenDeleteById_thenProductIsRemoved() {
        // Given
        Product product = new Product();
        product.setName("Product to delete");
        product.setPrice(15.0);
        Product savedProduct = productRepository.save(product);

        // When
        productRepository.deleteById(savedProduct.getId());

        // Then
        Optional<Product> deletedProduct = productRepository.findById(savedProduct.getId());
        assertThat(deletedProduct).isEmpty();
    }
}
