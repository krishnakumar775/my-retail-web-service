package com.myretail.restservice;

import com.myretail.restservice.controller.ProductController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test to validate all beans are loaded correctly.
 */

@SpringBootTest
class RestServiceApplicationTests {

    @Autowired
    private ProductController productController;

    @Test
    void contextLoads() {
        assertThat(productController).isNotNull();
    }

}
