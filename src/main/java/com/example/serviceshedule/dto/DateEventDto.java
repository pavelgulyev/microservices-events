package com.example.serviceshedule.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.OffsetDateTime;

@Data
public class DateEventDto implements Serializable{
    @JsonProperty("datestart")
    private final String dateStartEvent;
    @JsonProperty("dateend")
    private final String dateEndEvent;
}
