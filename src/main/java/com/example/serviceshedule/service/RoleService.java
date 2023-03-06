package com.example.serviceshedule.service;

import com.example.serviceshedule.entity.Role;
import com.example.serviceshedule.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleRepository repository;
//    public Faculty create(FacultyDto dto) {
//        return repository.save(Faculty.builder()
//                .nameFaculty(dto.getNameFaculty())
//                .build());
//    }
    public Role createRole(Role role) {
        Role role1 = new Role();
        role1.setNameRole(role.getNameRole());
        return repository.save(role1);
    }
    public List<Role> readAll() {
        return repository.findAll();
    }
    public Role update(Role role) {
        return repository.save(role);
    }
    public Role getRoleById(Long id) {
        return repository.findById(id).orElse(null);
    }
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
