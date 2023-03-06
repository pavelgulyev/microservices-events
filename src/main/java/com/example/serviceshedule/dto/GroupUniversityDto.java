package com.example.serviceshedule.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class GroupUniversityDto implements Serializable {
//    @JsonProperty("id")
//    private Long id;
    @JsonProperty("name")
    private  String nameGroupUniversity;
    @JsonProperty("facultyid")
    private Long facultyid;
}
