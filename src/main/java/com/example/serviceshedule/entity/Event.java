package com.example.serviceshedule.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="event")
public class Event {
    @Id
    @SequenceGenerator(
            name = "event_sequence",
            sequenceName = "event_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "event_sequence"
    )
    private Long eventId;
    @Column(name = "nameEvent")
    private String nameEvent;
    @Column(name = "descriptionEvent", columnDefinition = "TEXT")
    private String descriptionEvent;
    @Column(name = "locationEvent")
    private String LocationEvent;
    @ManyToOne
    @JoinColumn(name = "class_event_class_event_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private ClassEvent classEvent;
    @ManyToOne
    @JoinColumn(name = "type_event_type_eventid")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private TypeEvent typeEvent;
    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Category category;
    @ManyToOne
    @JoinColumn(name = "user_sсhedule_user_schedule_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private UserSсhedule userSсhedule;
    @ManyToOne
    @JoinColumn(name = "group_university_group_university_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private groupUniversity groupUniversity;
    @ManyToOne
    @JoinColumn(name = "faculty_faculty_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Faculty faculty;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime dateStartEvent;
    @Column(name = "dateEndEvent")
//    @Temporal(TemporalType.TIMESTAMP)
//    @JsonFormat (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
//    @JsonFormat(pattern = "2019-10-21T13:00+02:00")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime dateEndEvent;
}
