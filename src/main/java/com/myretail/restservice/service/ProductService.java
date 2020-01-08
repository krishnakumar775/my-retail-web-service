package com.myretail.restservice.service;


import com.myretail.restservice.exception.ResourceNotFoundException;
import com.myretail.restservice.model.Price;
import com.myretail.restservice.model.PriceUpdateRequest;
import com.myretail.restservice.model.Product;
import com.myretail.restservice.repository.PriceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.util.StringUtils.isEmpty;

@Service
@Slf4j
public class ProductService {

    private final ExternalApiService externalApiService;

    private final PriceRepository priceRepository;

    @Autowired
    public ProductService(final ExternalApiService externalApiService, final PriceRepository priceRepository) {
        this.externalApiService = externalApiService;
        this.priceRepository = priceRepository;

    }

    /**
     * Method to fetch the product details of the given id.
     *
     * @param id
     * @return product details or throw an exception if the item is not found.
     */

    public Product getProductDetails(long id) {

        log.debug("Fetching product details for id: {}", id);
        String name = externalApiService.getProductName(id);

        if (isEmpty(name)) {
            throw new ResourceNotFoundException("Product details not available");
        }

        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setPrice(getPrice(id));

        return product;

    }

    /**
     * Method to update the price of the product with the given id.
     *
     * @param id
     * @param priceUpdateRequest
     */

    public void updateProductPrice(long id, PriceUpdateRequest priceUpdateRequest) {

        Price price = getPrice(id);

        price.setCurrencyCode(priceUpdateRequest.getCurrency_code());
        price.setValue(priceUpdateRequest.getValue());

        priceRepository.save(price);

    }

    private Price getPrice(long id) {

        Price price = priceRepository.findById(id)
                .orElse(null);

        if (price == null) {
            log.error("Price information not available for id: {}", id);
            throw new ResourceNotFoundException("Price details not available");
        }

        return price;
    }
}
