package io.pivotal.workshop.service;


import io.pivotal.workshop.domain.Product;
import io.pivotal.workshop.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        super();
        this.productRepository = productRepository;
    }

    public Product save(Product product) {
        Product savedProduct = productRepository.save(product);
        return savedProduct;
    }

    public Optional<Product> getProduct(Long productId) {
        return productRepository.findById(productId);
    }

    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }

}
