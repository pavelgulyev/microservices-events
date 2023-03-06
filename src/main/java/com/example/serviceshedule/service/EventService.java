package com.example.serviceshedule.service;

import com.example.serviceshedule.dto.EventDto;
import com.example.serviceshedule.entity.Event;
import com.example.serviceshedule.entity.Faculty;
import com.example.serviceshedule.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

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
        return eventRepository.save(Event.builder()
                .nameEvent(dto.getNameEvent())
                .descriptionEvent(dto.getDescriptionEvent())
                .faculty(facultyRepository.getById(dto.getFaculty()))
                .groupUniversity(groupUniversityRepository.getById(dto.getGroupUniversity()))
                .nameEvent(dto.getNameEvent())
                .nameEvent(dto.getNameEvent())
                .build());
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
    public Event getUserScheduleById(Long id) {
        return eventRepository.findById(id).orElse(null);
    }
    public List<Event> getByRoleId(Long id) {
        return eventRepository.findByClassEvent(id);
    }
    public void delete(Long id) {
        eventRepository.deleteById(id);
    }
}
