package com.example.serviceshedule.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class SearchDto {
    @JsonProperty("value1")
    private String value1;
    @JsonProperty("value2")
    private String value2;
    @JsonProperty("value3")
    private String value3;
}
