package com.example.serviceshedule.service;

import com.example.serviceshedule.dto.UserScheduleDto;
import com.example.serviceshedule.entity.UserSсhedule;
import com.example.serviceshedule.repository.RoleRepository;
import com.example.serviceshedule.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserScheduleService {
    @Autowired
    private RoleRepository facultyRepository;
    @Autowired
    private UserRepository groupUniversityRepository;
    @Transactional
    public UserSсhedule createFromDTO(UserScheduleDto dto) {
        return groupUniversityRepository.save(UserSсhedule.builder()
                .firstNameUserSchedule(dto.getFirstNameUserSchedule())
                .lastNameUserSchedule(dto.getLastNameUserSchedule())
                .login(dto.getLogin())
                .passwordHash(dto.getPasswordHash())
                .role(facultyRepository.getById(dto.getRoleid()))
                .build());
    }
    @Transactional
    public UserSсhedule create(UserScheduleDto dto) {
        return groupUniversityRepository.save(groupPostDtoToUserSchedule(dto));
    }
    public UserSсhedule groupPostDtoToUserSchedule(UserScheduleDto dto) {
        UserSсhedule userSсhedule =new UserSсhedule();
        userSсhedule.setFirstNameUserSchedule(dto.getFirstNameUserSchedule());
        userSсhedule.setLastNameUserSchedule(dto.getLastNameUserSchedule());
        userSсhedule.setLogin(dto.getLogin());
        userSсhedule.setPasswordHash(dto.getPasswordHash());
        userSсhedule.setRole(facultyRepository.getById(dto.getRoleid()));
        return userSсhedule;
    }
//    public groupUniversity createGroupUniversity(groupUniversity dto) {
//        groupUniversity group =new groupUniversity();
//        group.setNamegroupUniversity(dto.getNamegroupUniversity());
//        group.setFaculty(dto.getFaculty());
//        return groupUniversityRepository.save(group);
//    }

    public List<UserSсhedule> readAll() {
        return groupUniversityRepository.findAll();
    }
    @Modifying
    @Transactional
    public UserSсhedule update(UserSсhedule product) {
        return groupUniversityRepository.save(product);
    }
    public UserSсhedule getUserScheduleById(Long id) {
        return groupUniversityRepository.findById(id).orElse(null);
    }
    public List<UserSсhedule> getByRoleId(Long id) {
        return groupUniversityRepository.findByRole(id);
    }
    public void delete(Long id) {
        groupUniversityRepository.deleteById(id);
    }
}
