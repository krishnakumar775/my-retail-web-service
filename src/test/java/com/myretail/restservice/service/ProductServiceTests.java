package com.myretail.restservice.service;


import com.myretail.restservice.model.Price;
import com.myretail.restservice.model.Product;
import com.myretail.restservice.repository.PriceRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTests {


    @InjectMocks
    private ProductService productService;

    @Mock
    private PriceRepository priceRepository;

    @Mock
    private ExternalApiService externalApiService;

    @Test
    public void getProductDetails() throws Exception {

        Product product = new Product();

        Price price = new Price();
        price.setValue(25.4);
        price.setCurrencyCode("USD");

        product.setPrice(price);
        product.setName("Name");
        product.setId(13860428L);

        when(priceRepository.findById(13860428L)).thenReturn(Optional.of(price));
        when(externalApiService.getProductName(13860428L)).thenReturn("Product_Name");

        Product productResponse = productService.getProductDetails(13860428L);

        assertEquals(productResponse.getName(), "Product_Name");

    }
}
