package com.myretail.restservice.controller;

import com.myretail.restservice.model.Price;
import com.myretail.restservice.model.Product;
import com.myretail.restservice.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ProductService productService;

    @Test
    public void getProductDetailsForGivenId() throws Exception {

        Product product = new Product();

        Price price = new Price();
        price.setValue(25.4);
        price.setCurrencyCode("USD");

        product.setPrice(price);
        product.setName("Name");
        product.setId(13860428L);

        given(productService.getProductDetails(13860428L)).willReturn(product);

        mvc.perform(get("/products/13860428")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

}
