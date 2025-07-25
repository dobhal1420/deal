package com.domain.deal.assesment.dtos;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DealResponse {
    @JsonProperty("articleId")
    private String articleId;

    @JsonProperty("status")
    private String status;
}


