package com.example.serviceshedule.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Date;

//@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
//@Table(name="dateEvent")
public class DateEvent {
//    @Id
//    @SequenceGenerator(
//            name = "dateEvent_sequence",
//            sequenceName = "dateEvent_sequence",
//            allocationSize = 1
//    )
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "dateEvent_sequence"
//    )
//    private Long dateEventId;
//    @Column(name = "dateStartEvent")
////    @Temporal(TemporalType.TIMESTAMP)
//////    @JsonFormat (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
////    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
//    @JsonSerialize(using = LocalDateTimeSerializer.class)
//    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
//    private LocalDateTime   dateStartEvent;
//    @Column(name = "dateEndEvent")
////    @Temporal(TemporalType.TIMESTAMP)
////    @JsonFormat (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
////    @JsonFormat(pattern = "2019-10-21T13:00+02:00")
//    @JsonSerialize(using = LocalDateTimeSerializer.class)
//    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
//    private LocalDateTime dateEndEvent;
}
