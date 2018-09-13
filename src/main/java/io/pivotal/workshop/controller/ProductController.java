package io.pivotal.workshop.controller;

import io.pivotal.workshop.domain.*;
import io.pivotal.workshop.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class ProductController {
    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("amazoncommerce/product")
    public Product createProduct(@RequestBody Product product) {
        Product productSaved = productService.save(product);
        return productSaved;
    }

    @GetMapping("amazoncommerce/product/{productId}")
    public Product get(@PathVariable("productId") Long productId) {
        Optional<Product> productRetrieved = productService.getProduct(productId);
        Product product = productRetrieved.get();
        return product;
    }

    @PutMapping("amazoncommerce/product/{productId}")
    public Product updateProduct(@RequestBody Product product) {
        Product productUpdated = productService.save(product);
        return productUpdated;
    }

    @DeleteMapping("amazoncommerce/product/{productId}")
    public ResponseEntity<?> delete(@PathVariable("productId") long productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.ok().body("Product deletion successful");
    }
}
