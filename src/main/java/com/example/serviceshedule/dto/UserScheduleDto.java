package com.example.serviceshedule.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.Data;

@Data
public class UserScheduleDto {
    @JsonProperty("firstName")
    private  String firstNameUserSchedule;
    @JsonProperty("lastName")
    private  String lastNameUserSchedule;
    @JsonProperty("role_id")
    private Long roleid;
    @JsonProperty("login")
    private String login;
    @JsonProperty("password")
    private String passwordHash;
}
