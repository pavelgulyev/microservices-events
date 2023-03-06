package com.example.serviceshedule.entity;

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
@Table(name="classEvent")
public class ClassEvent {
    @Id
    @SequenceGenerator(
            name = "classEvent_sequence",
            sequenceName = "classEvent_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "classEvent_sequence"
    )
    private Long classEventId;
    @Column(name = "nameclassEvent")
    private String nameClassEvent;
}
