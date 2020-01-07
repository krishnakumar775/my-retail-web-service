package com.myretail.restservice.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity(name = "price")
public class Price {

    @Id
    @JsonIgnore
    private long id;

    private Double value;

    @Column(name = "currency_code")
    @JsonProperty("currency_code")
    private String currencyCode;


}
