package com.example.serviceshedule.controller;

//import com.example.serviceshedule.entity.Faculty;
import com.example.serviceshedule.dto.GroupUniversityDto;
import com.example.serviceshedule.entity.groupUniversity;
import com.example.serviceshedule.service.GroupUniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/webshedule")
public class GroupUniversityController {
    @Autowired
    private GroupUniversityService groupUniversityService;
    @PostMapping("/group")
    public ResponseEntity<groupUniversity> create(@RequestBody GroupUniversityDto dto) {
        //facultyService.create(dto);
        return mappingResponseFaculty(groupUniversityService.create(dto));
    }
    @DeleteMapping("/group/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        groupUniversityService.delete(id);
        return HttpStatus.OK;
    }
    @GetMapping("/groups")
    public ResponseEntity<List<groupUniversity>> readAll() {
        return mappingResponseListFaculty(groupUniversityService.readAll());
    }
    @GetMapping("/groupdto")
    public ResponseEntity<GroupUniversityDto> readGroupUniversityDto() {
        GroupUniversityDto dto = new GroupUniversityDto();
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
    @GetMapping("/group/{id}")
    public ResponseEntity<groupUniversity> findById(@PathVariable Long id) {
        groupUniversity findFaculty = groupUniversityService.getGroupUniversityById(id);
        return mappingResponseFaculty(findFaculty);
    }
    @GetMapping("/groups/faculty/{id}")
    public ResponseEntity<List<groupUniversity>> findByFacultyId(@PathVariable Long id) {
        //groupUniversity findFaculty = facultyService.readByCategoryId(id);
        return mappingResponseListFaculty(groupUniversityService.readByCategoryId(id));
    }
    @PutMapping("/group")
    public ResponseEntity<groupUniversity> update(
                                          @RequestBody groupUniversity faculty) {
        return mappingResponseFaculty(groupUniversityService.update(faculty));
    }
    private ResponseEntity<groupUniversity> mappingResponseFaculty(groupUniversity faculty) {
        if (faculty ==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(faculty, HttpStatus.OK);
    }

    private ResponseEntity<List<groupUniversity>> mappingResponseListFaculty(List<groupUniversity> faculties) {
        if (faculties.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(faculties, HttpStatus.OK);
    }
}
