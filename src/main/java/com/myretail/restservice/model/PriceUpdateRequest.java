package com.myretail.restservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PriceUpdateRequest {

    private Double valie;
    private String currency_code;


}
