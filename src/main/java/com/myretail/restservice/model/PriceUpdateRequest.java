package com.myretail.restservice.model;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PriceUpdateRequest {

    private Double value;
    private String currency_code;


}
