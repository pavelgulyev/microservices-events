package com.example.serviceshedule.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@NoArgsConstructor
@Data
public class EventDto implements Serializable {
    @JsonProperty("name")
    private String nameEvent;
    @JsonProperty("description")
    private String descriptionEvent;
    @JsonProperty("datestart")
    private String dateStartEvent;
    @JsonProperty("dateend")
    private String dateEndEvent;
    @JsonProperty("classevent_id")
    private Long classEventid;
    @JsonProperty("typeevent_id")
    private Long typeEventid;
    @JsonProperty("usersсhedul_id")
    private Long userSсhedulid;
    @JsonProperty("groupuniversit_id")
    private Long groupUniversity;
    @JsonProperty("faculty_id")
    private Long faculty;
    @JsonProperty("category_id")
    private Long category;
}
