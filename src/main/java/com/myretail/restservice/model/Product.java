package com.myretail.restservice.model;

import lombok.Data;

@Data
public class Product {

    private Long id;

    private String name;

    private Price price;

}
