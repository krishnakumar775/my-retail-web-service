package com.myretail.restservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class ProductsIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getProductDetails() throws Exception {
        this.mockMvc.perform(get("/products/13860428"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("The Big Lebowski")))
                .andExpect(content().string(containsString("USD")));

    }

    @Test
    public void updateProductPrice() throws Exception {
        this.mockMvc.perform(put("/products/13860428")
                .contentType("application/json")
                .content(getProductPriceUpdateRequestContentAsString()))

                .andExpect(status().isOk())
                .andExpect(content().string(containsString("The Big Lebowski")))
                .andExpect(content().string(containsString("USD")))
                .andExpect(content().string(containsString("29")));

    }

    private String getProductPriceUpdateRequestContentAsString() {

        return "{\n" +
                "    \"value\": 29,\n" +
                "    \"currency_code\": \"USD\"\n" +
                "}";
    }
}