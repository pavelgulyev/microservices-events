package com.example.serviceshedule.controller;

//import com.example.serviceshedule.entity.Faculty;
import com.example.serviceshedule.dto.UserScheduleDto;
import com.example.serviceshedule.entity.UserSсhedule;
import com.example.serviceshedule.service.UserScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/webshedule")
public class EventController {
    @Autowired
    private UserScheduleService groupUniversityService;
    @PostMapping("/event")
    public ResponseEntity<UserSсhedule> create(@RequestBody UserScheduleDto dto) {
        //facultyService.create(dto);
        return mappingResponseFaculty(groupUniversityService.createFromDTO(dto));
    }
    @DeleteMapping("/event/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        groupUniversityService.delete(id);
        return HttpStatus.OK;
    }
    @GetMapping("/events")
    public ResponseEntity<List<UserSсhedule>> readAll() {
        return mappingResponseListFaculty(groupUniversityService.readAll());
    }
    @GetMapping("/eventto")
    public ResponseEntity<UserScheduleDto> readGroupUniversityDto() {
        UserScheduleDto dto = new UserScheduleDto();
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
    @GetMapping("/event/{id}")
    public ResponseEntity<UserSсhedule> findById(@PathVariable Long id) {
        UserSсhedule findFaculty = groupUniversityService.getUserScheduleById(id);
        return mappingResponseFaculty(findFaculty);
    }
    @GetMapping("/event/typeevent/{id}")
    public ResponseEntity<List<UserSсhedule>> findByFacultyId(@PathVariable Long id) {
        //groupUniversity findFaculty = facultyService.readByCategoryId(id);
        return mappingResponseListFaculty(groupUniversityService.getByRoleId(id));
    }
    @PutMapping("/event")
    public ResponseEntity<UserSсhedule> update(
                                          @RequestBody UserSсhedule faculty) {
        return mappingResponseFaculty(groupUniversityService.update(faculty));
    }
    private ResponseEntity<UserSсhedule> mappingResponseFaculty(UserSсhedule faculty) {
        if (faculty ==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(faculty, HttpStatus.OK);
    }

    private ResponseEntity<List<UserSсhedule>> mappingResponseListFaculty(List<UserSсhedule> userSсhedules) {
        if (userSсhedules.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userSсhedules, HttpStatus.OK);
    }
}
