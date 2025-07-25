package com.domain.deal.assesment.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DealRequest {
    @JsonProperty("articleId")
    private String articleId;

    @JsonProperty("price")
    private double price;

    @JsonProperty("rrp")
    private double rrp;

    @JsonProperty("quantity")
    private int quantity;

    @JsonProperty("category")
    private String category;

}

