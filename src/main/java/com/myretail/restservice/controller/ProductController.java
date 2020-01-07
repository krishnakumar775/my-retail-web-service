package com.myretail.restservice.controller;

import com.myretail.restservice.model.Product;
import com.myretail.restservice.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(final ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products/{id}")
    public Product getProductDetails(@PathVariable long id) {
        log.debug("Request to get the product details for the id: {}", id);
        return productService.getProductDetails(id);

    }
}
