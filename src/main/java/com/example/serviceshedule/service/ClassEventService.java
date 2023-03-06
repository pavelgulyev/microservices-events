package com.example.serviceshedule.service;

import com.example.serviceshedule.entity.ClassEvent;
import com.example.serviceshedule.repository.ClassEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassEventService {
    @Autowired
    private ClassEventRepository repository;
//    public Faculty create(FacultyDto dto) {
//        return repository.save(Faculty.builder()
//                .nameFaculty(dto.getNameFaculty())
//                .build());
//    }
    public ClassEvent createFaculty(ClassEvent classEvent) {
        ClassEvent classEvent1 =ClassEvent.builder()
                .nameClassEvent(classEvent.getNameClassEvent())
                .build();
        return repository.save(classEvent1);
    }
    public List<ClassEvent> readAll() {
        return repository.findAll();
    }
    public ClassEvent update(ClassEvent classEvent) {
        return repository.save(classEvent);
    }
    public ClassEvent getFacultyById(Long id) {
        return repository.findById(id).orElse(null);
    }
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
