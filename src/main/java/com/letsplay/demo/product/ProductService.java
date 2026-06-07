package com.letsplay.demo.product;

import org.springframework.stereotype.Service;

import com.letsplay.demo.exception.NotFoundException;
import com.letsplay.demo.product.DTOs.CreateProductRequest;
import com.letsplay.demo.product.DTOs.UpdateProductRequest;

import java.util.List;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product createProduct(CreateProductRequest req) {
        Product product = new Product();
        product.setName(req.name());
        product.setDescription(req.description());
        product.setPrice(req.price());
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(String id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product not found"));
    }

    public List<Product> getProductsByUser(String userId) {
        return productRepository.findByUserId(userId);
    }

    public Product updateProduct(String id, UpdateProductRequest updated) {
        Product product = getProductById(id);

        product.setName(updated.name());
        product.setDescription(updated.description());
        product.setPrice(updated.price());

        return productRepository.save(product);
    }

    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }
}