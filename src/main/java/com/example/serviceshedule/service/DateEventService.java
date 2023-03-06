package com.example.serviceshedule.service;

import com.example.serviceshedule.dto.DateEventDto;
import com.example.serviceshedule.dto.UserScheduleDto;
import com.example.serviceshedule.entity.DateEvent;

import com.example.serviceshedule.entity.UserSсhedule;
import com.example.serviceshedule.repository.DateEventRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class DateEventService {
//    @Autowired
//    private DateEventRepository repository;
//    public DateEvent create(DateEvent dto) {
//        return repository.save(dto);
//    }
//    public UserSсhedule createFromDTO(DateEventDto dto) {
//        return repository.save(DateEvent.builder()
//                .dateEndEvent()
//                .build()
//        );
//    }
//    public void my()
//    {
//        LocalDateTime ldt = LocalDateTime.now();
//
//// Change the ZoneId as required e.g. ZoneId.of("Europe/London")
//        ZoneId zoneId = ZoneId.of("Europe/Moscow");
//        OffsetDateTime my = OffsetDateTime.of(ldt,zoneId);
//    }
//    public void set(String odtString) {
//        OffsetDateTime odt;
//        final String pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSxx";
//        DateTimeFormatter dtfB = DateTimeFormatter.ofPattern(pattern);
//        OffsetDataTime::of(LocalDataTime, ZoneOffset);
//        odt = OffsetDateTime.parse(odtString, dtfB);
//    }
//    @Transactional
//    public DateEvent createFaculty(DateEvent myfaculty) {
//        DateEvent faculty = new DateEvent();
//        faculty.setDateStartEvent(myfaculty.getDateStartEvent());
//        faculty.setDateEndEvent(myfaculty.getDateEndEvent());
//        return repository.save(faculty);
//    }
//    public List<DateEvent> readAll() {
//        return repository.findAll();
//    }
//    public DateEvent update(DateEvent faculty) {
//        return repository.save(faculty);
//    }
//    public DateEvent getFacultyById(Long id) {
//        return repository.findById(id).orElse(null);
//    }
//    public void delete(Long id) {
//        repository.deleteById(id);
//    }
}
