package com.example.serviceshedule.controller;


import com.example.serviceshedule.dto.EventDto;
import com.example.serviceshedule.dto.SearchDto;
import com.example.serviceshedule.entity.Event;
import com.example.serviceshedule.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/webshedule")
public class EventController {
    @Autowired
    private EventService service;
    @PostMapping("/event")
    public ResponseEntity<Event> create(@RequestBody EventDto dto) {
        //facultyService.create(dto);
        return mappingResponseFaculty(service.createFromDTO(dto));
    }
    @DeleteMapping("/event/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        service.delete(id);
        return HttpStatus.OK;
    }
    @GetMapping("/events")
    public ResponseEntity<List<Event>> readAll() {
        return mappingResponseListFaculty(service.readAll());
    }
    @GetMapping("/eventdto")
    public ResponseEntity<EventDto> readGroupUniversityDto() {
        EventDto dto = new EventDto();
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
    @GetMapping("/event/{id}")
    public ResponseEntity<Event> findById(@PathVariable Long id) {
        Event findFaculty = service.getEventById(id);
        return mappingResponseFaculty(findFaculty);
    }
    @GetMapping("/event/organizer/login")
    public ResponseEntity<List<Event>> findByEventLogin(@RequestBody SearchDto searchDto) {
        return mappingResponseListFaculty(service.getByUserLogin(searchDto.getValue1()));
    }
    @GetMapping("/event/date/range")
    public ResponseEntity<List<Event>> findAllEventWithDateRange(@RequestBody SearchDto searchDto) {
        return mappingResponseListFaculty(service.findAllEventWithDateRange(searchDto.getValue1(),
                searchDto.getValue2()));
    }
    @GetMapping("/event/date/day")
    public ResponseEntity<List<Event>> findAllEventWithDateDayStart(@RequestBody SearchDto searchDto) {
        return mappingResponseListFaculty(service.findAllEventWithDateDayStart(searchDto.getValue1()));
    }
    @GetMapping("/event/location")
    public ResponseEntity<List<Event>> getByLocation(@RequestBody SearchDto searchDto) {
        return mappingResponseListFaculty(service.getByLocation(searchDto.getValue1()));
    }
//    @GetMapping("/event/organizer/full_name")
//    public ResponseEntity<List<Event>> findByUserfull_name(@RequestBody SearchDto searchDto) {
//        //groupUniversity findFaculty = facultyService.readByCategoryId(id);
//        return mappingResponseListFaculty(service.getByUserLogin(searchDto.getValue1()));
//    }

    @PutMapping("/event")
    public ResponseEntity<Event> update(
                                          @RequestBody Event faculty) {
        return mappingResponseFaculty(service.update(faculty));
    }
    private ResponseEntity<Event> mappingResponseFaculty(Event faculty) {
        if (faculty ==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(faculty, HttpStatus.OK);
    }

    private ResponseEntity<List<Event>> mappingResponseListFaculty(List<Event> userSсhedules) {
        if (userSсhedules.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userSсhedules, HttpStatus.OK);
    }
}
