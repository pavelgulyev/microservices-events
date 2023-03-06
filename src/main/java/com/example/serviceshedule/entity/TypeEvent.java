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
@Table(name="type_event")
public class TypeEvent {
    @Id
    @SequenceGenerator(
            name = "type_event_sequence",
            sequenceName = "type_event_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "type_event_sequence"
    )
    private Long type_eventid;
    @Column(name = "nametype_event")
    @JsonProperty("nametype_event")
    private String nametype_event;
}
