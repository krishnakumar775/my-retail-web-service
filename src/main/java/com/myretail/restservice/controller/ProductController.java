package com.myretail.restservice.controller;

import com.myretail.restservice.model.PriceUpdateRequest;
import com.myretail.restservice.model.Product;
import com.myretail.restservice.service.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@Slf4j
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(final ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Find Product details by id",
            notes = "Provide an id to look up details of the product with that id",
            response = Product.class)
    public Product getProductDetails(@ApiParam(value = "ID value for the product you need to retrieve", required = true)
                                     @PathVariable long id) {
        log.debug("Request to get the product details for the id: {}", id);

        return productService.getProductDetails(id);

    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update Product Price by id",
            notes = "Provide an id and new price details to update the price of the product with that id",
            response = Product.class)
    public Product updateProductPrice(@ApiParam(value = "ID value for the product you need to update the price", required = true)
                                      @PathVariable long id,
                                      PriceUpdateRequest priceUpdateRequest) {
        log.debug("Request to update the price details for the id: {}", id);
        productService.updateProductPrice(id, priceUpdateRequest);

        return productService.getProductDetails(id);

    }
}
