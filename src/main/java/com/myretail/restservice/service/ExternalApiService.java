package com.myretail.restservice.service;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class ExternalApiService {

    private final RestTemplate restTemplate;

    private static final String EMPTY_STRING = "";

    @Autowired
    public ExternalApiService(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Method to fetch the product name from the external url for a given product id.
     *
     * @param id
     * @return valid name or EMPTY STRING if a valid name is not found.
     */

    String getProductName(long id) {

        String fullUrl = "https://redsky.target.com/v2/pdp/tcin/" + id +
                "?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics";

        String name;

        try {
            log.debug("Making rest call to url: {}", fullUrl);

            JsonNode root = restTemplate.getForObject(fullUrl, JsonNode.class);
            if (root == null) {
                //return empty string and let the caller handle if a proper name is not found
                return EMPTY_STRING;
            }

            name = root.at("/product/item/product_description/title").asText();
            if (name == null) {
                //return empty string and let the caller handle if a proper name is not found
                return EMPTY_STRING;
            }
        } catch (Exception e) {
            //return empty string and let the caller handle if a proper name is not returned
            return EMPTY_STRING;
        }

        log.info("Name is: {}", name);
        return name;
    }
}

