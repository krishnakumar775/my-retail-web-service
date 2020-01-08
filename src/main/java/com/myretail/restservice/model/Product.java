package com.myretail.restservice.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "Product details")
public class Product {

    @ApiModelProperty(notes = "Unique id of the product")
    private Long id;

    @ApiModelProperty(notes = "Name of the product")
    private String name;

    @ApiModelProperty(notes = "Price details of the product")
    private Price price;

}
