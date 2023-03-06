package com.example.serviceshedule.controller;

import com.example.serviceshedule.entity.Role;
import com.example.serviceshedule.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/webshedule")
public class RoleController {
    @Autowired
    private RoleService service;
    @PostMapping("/role")
    public ResponseEntity<Role> create(@RequestBody Role dto) {
        return mappingResponseCategory(service.createRole(dto));
    }
    @GetMapping("/roles")
    public ResponseEntity<List<Role>> readAll() {
        return mappingResponseListCategory(service.readAll());
    }
    @GetMapping("/role/{id}")
    public ResponseEntity<Role> fingById(@PathVariable Long id) {
        Role findFaculty = service.getRoleById(id);

        if (findFaculty ==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return mappingResponseCategory(findFaculty);
    }
    @PutMapping("/role/{id}")
    public ResponseEntity<Role> update(@PathVariable Long id,
                                          @RequestBody Role faculty) {
        return mappingResponseCategory(service.update(faculty));
    }
    private ResponseEntity<Role> mappingResponseCategory(Role category) {
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
    @DeleteMapping("/role/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        service.delete(id);
        return HttpStatus.OK;
    }

    private ResponseEntity<List<Role>> mappingResponseListCategory(List<Role> categories) {
        if (categories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
}
