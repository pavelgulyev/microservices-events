package com.example.serviceshedule.entity;

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
@Table(name="type_location")
public class TypeLocation {
    @Id
    @SequenceGenerator(
            name = "type_location_sequence",
            sequenceName = "type_location_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "type_location_sequence"
    )
    @JsonProperty("type_location_id")
    private Long locationId;
    @Column(name = "nametypelocation")
    @JsonProperty("name_type_location")
    private String nametype_location;

}
