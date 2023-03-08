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
import java.util.List;

@Service
public class EventService {
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
        return  eventRepository.save(event);
    }

//    @Transactional
//    public Event create(UserScheduleDto dto) {
//        return eventRepository.save(groupPostDtoToUserSchedule(dto));
//    }
//    public Event groupPostDtoToUserSchedule(UserScheduleDto dto) {
//        Event userSсhedule =new Event();
//        userSсhedule.setFirstNameUserSchedule(dto.getFirstNameUserSchedule());
//        userSсhedule.setLastNameUserSchedule(dto.getLastNameUserSchedule());
//        userSсhedule.setLogin(dto.getLogin());
//        userSсhedule.setPasswordHash(dto.getPasswordHash());
//        userSсhedule.setRole(userRepository.getById(dto.getRoleid()));
//        return userSсhedule;
//    }
//    public groupUniversity createGroupUniversity(groupUniversity dto) {
//        groupUniversity group =new groupUniversity();
//        group.setNamegroupUniversity(dto.getNamegroupUniversity());
//        group.setFaculty(dto.getFaculty());
//        return groupUniversityRepository.save(group);
//    }

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
    public void delete(Long id) {
        eventRepository.deleteById(id);
    }
}
