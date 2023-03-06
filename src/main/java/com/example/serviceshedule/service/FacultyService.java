package com.example.serviceshedule.service;

import com.example.serviceshedule.dto.FacultyDto;
import com.example.serviceshedule.entity.Faculty;
import com.example.serviceshedule.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyService {
    @Autowired
    private FacultyRepository repository;
    public Faculty create(FacultyDto dto) {
        return repository.save(Faculty.builder()
                .nameFaculty(dto.getNameFaculty())
                .build());
    }
    public Faculty createFaculty(Faculty myfaculty) {
        Faculty faculty = new Faculty();
        faculty.setNameFaculty(myfaculty.getNameFaculty());
        return repository.save(faculty);
    }
    public List<Faculty> readAll() {
        return repository.findAll();
    }
    public Faculty update(Faculty faculty) {
        return repository.save(faculty);
    }
    public Faculty getFacultyById(Long id) {
        return repository.findById(id).orElse(null);
    }
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
