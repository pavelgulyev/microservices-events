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
@Table(name="userShedule")
public class UserSсhedule {
    @Id
    @SequenceGenerator(
            name = "userSchedule_sequence",
            sequenceName = "userSchedule_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "userSchedule_sequence"
    )
    private Long userScheduleId;
    @Column(name = "firstNameUserSchedule")
    @JsonProperty("firstName")
    private String firstNameUserSchedule;
    @Column(name = "lastNameUserSchedule")
    @JsonProperty("lastName")
    private String lastNameUserSchedule;
    //@Column(name = "login", nullable = false, unique = true)
    @Column(name = "login")
    @JsonProperty("login")
    private String login;
    @Column(name = "password_hash")
    @JsonProperty("password")
    private String passwordHash;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Role role;
}
