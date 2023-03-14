package com.example.serviceshedule.service;

import com.example.serviceshedule.dto.EventDto;
import com.example.serviceshedule.entity.Event;
import com.example.serviceshedule.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.List;

@Service
public class EventService {

    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ClassEventRepository classEventRepository;
    @Autowired
    private TypeEventRepository typeEventRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private GroupUniversityRepository groupUniversityRepository;
    @Autowired
    private FacultyRepository facultyRepository;
    @Autowired
    private EventRepository eventRepository;
    @Transactional
    public Event createFromDTO(EventDto dto) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        Event event =new Event();
        event.setNameEvent(dto.getNameEvent());
        event.setDescriptionEvent(dto.getDescriptionEvent());
        event.setFaculty(facultyRepository.getById(dto.getFaculty()));
        event.setGroupUniversity(groupUniversityRepository.getById(dto.getGroupUniversity()));
        event.setDateStartEvent(LocalDateTime.parse(dto.getDateStartEvent(), formatter));
        event.setDateEndEvent(LocalDateTime.parse(dto.getDateEndEvent(), formatter));
        event.setCategory(categoryRepository.getById(dto.getCategory()));
        event.setClassEvent(classEventRepository.getById(dto.getClassEventid()));
        event.setTypeEvent(typeEventRepository.getById(dto.getTypeEventid()));
        event.setUserSсhedule(userRepository.getById(dto.getUserSсhedulid()));
        event.setLocation(locationRepository.getById(dto.getLocation()));
        return  eventRepository.save(event);
    }



    public List<Event> readAll() {
        return eventRepository.findAll();
    }
    @Modifying
    @Transactional
    public Event update(Event product) {
        return eventRepository.save(product);
    }
    public Event getEventById(Long id) {
        return eventRepository.findById(id).orElse(null);
    }
    public List<Event> getByUserLogin(String login) {
        return eventRepository.getByUserLogin(login);
    }
    public List<Event> findAllEventWithDateRange(String startdate,String enddate) {
        DateTimeFormatter DATE_FORMAT =
                new DateTimeFormatterBuilder().appendPattern("yyyy-MM-dd[ [HH][:mm][:ss][.SSS]]")
                        .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
                        .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
                        .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
                        .toFormatter();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime start =  LocalDateTime.parse(startdate, DATE_FORMAT);
        LocalDateTime end = LocalDateTime.parse(enddate, DATE_FORMAT);
        return eventRepository.findAllEventWithDateRange(start,end);
    }
    public List<Event> findAllEventWithDateDayStart(String startdate) {
        DateTimeFormatter DATE_FORMAT =
                new DateTimeFormatterBuilder().appendPattern("yyyy-MM-dd[ [HH][:mm][:ss][.SSS]]")
                        .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
                        .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
                        .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
                        .toFormatter();
        LocalDateTime start =  LocalDateTime.parse(startdate, DATE_FORMAT);
        return eventRepository.findAllEventWithDateDayStart(start);
    }
    public List<Event> getByLocation(String location) {
        return eventRepository.getByLocation(location);
    }
    public void delete(Long id) {
        eventRepository.deleteById(id);
    }
}
