package com.example.serviceshedule.controller;

import com.example.serviceshedule.dto.FacultyDto;
import com.example.serviceshedule.entity.Faculty;
import com.example.serviceshedule.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/webshedule")
public class FacultyController {
    @Autowired
    private FacultyService facultyService;
//    @GetMapping("/hello")
//    public String sayHello() {
//        return "Hello ";
//    }
    @PostMapping("/faculty")
    public ResponseEntity<Faculty> create(@RequestBody Faculty dto) {
        return mappingResponseFaculty(facultyService.createFaculty(dto));
    }
    @GetMapping("/faculties")
    public ResponseEntity<List<Faculty>> readAll() {
        return mappingResponseListFaculty(facultyService.readAll());
    }
    @GetMapping("/faculty/{id}")
    public ResponseEntity<Faculty> fingById(@PathVariable Long id) {
        Faculty findFaculty = facultyService.getFacultyById(id);

        if (findFaculty ==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return mappingResponseFaculty(findFaculty);
    }
    @PutMapping("/faculty/{id}")
    public ResponseEntity<Faculty> update(@PathVariable Long id,
                                          @RequestBody Faculty faculty) {
        return mappingResponseFaculty(facultyService.update(faculty));
    }
    private ResponseEntity<Faculty> mappingResponseFaculty(Faculty faculty) {
        return new ResponseEntity<>(faculty, HttpStatus.OK);
    }
    @DeleteMapping("/faculty/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        facultyService.delete(id);
        return HttpStatus.OK;
    }

    private ResponseEntity<List<Faculty>> mappingResponseListFaculty(List<Faculty> faculties) {
        if (faculties.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(faculties, HttpStatus.OK);
    }
}
