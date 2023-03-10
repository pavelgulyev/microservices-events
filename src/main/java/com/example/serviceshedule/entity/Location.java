package com.example.serviceshedule.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="location")
public class Location {
    @Id
    @SequenceGenerator(
            name = "location_sequence",
            sequenceName = "location_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "location_sequence"
    )
    @JsonProperty("location_id")
    private Long locationId;
    @Column(name = "namelocation")
    @JsonProperty("name_location")
    private String namelocation;
    @ManyToOne
    @JoinColumn(name = "type_location_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private TypeLocation type_location;
    @ManyToOne
    @JoinColumn(name = "building_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Building building;
}
