package com.example.serviceshedule.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class LocationDto implements Serializable {
    @JsonProperty("name")
    private String namelocation;
    @JsonProperty("type_location_id")
    private Long type_location;
    @JsonProperty("building_id")
    private Long building;

}
