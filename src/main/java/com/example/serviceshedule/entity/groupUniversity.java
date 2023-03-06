package com.example.serviceshedule.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name="groupUniversity")
public class groupUniversity {
    @Id
    @SequenceGenerator(
            name = "groupUniversity_sequence",
            sequenceName = "groupUniversity_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "groupUniversity_sequence"
    )
    private Long groupUniversityId;
    @Column(name = "namegroupUniversity")
    private String namegroupUniversity;
    //    @JsonIgnore()
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "faculty_id")

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Faculty faculty;
}
