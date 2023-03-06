package com.example.serviceshedule.service;

import com.example.serviceshedule.dto.GroupUniversityDto;
import com.example.serviceshedule.entity.groupUniversity;
import com.example.serviceshedule.repository.FacultyRepository;
import com.example.serviceshedule.repository.GroupUniversityRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupUniversityService {
    @Autowired
    private FacultyRepository facultyRepository;
    @Autowired
    private GroupUniversityRepository groupUniversityRepository;

    public groupUniversity create(GroupUniversityDto dto) {
        return groupUniversityRepository.save(groupPostDtoToGroupUniversity(dto));
    }
    public groupUniversity groupPostDtoToGroupUniversity(GroupUniversityDto dto) {
        groupUniversity group =new groupUniversity();
        group.setNamegroupUniversity(dto.getNameGroupUniversity());
        group.setFaculty(facultyRepository.getById(dto.getFacultyid()));
        System.out.println(group.getGroupUniversityId());
        return group;
    }
//    public groupUniversity createGroupUniversity(groupUniversity dto) {
//        groupUniversity group =new groupUniversity();
//        group.setNamegroupUniversity(dto.getNamegroupUniversity());
//        group.setFaculty(dto.getFaculty());
//        return groupUniversityRepository.save(group);
//    }

    public List<groupUniversity> readAll() {
        return groupUniversityRepository.findAll();
    }
    @Transactional
    public groupUniversity update(groupUniversity groupUniversity) {
        return groupUniversityRepository.save(groupUniversity);
    }
    public groupUniversity getGroupUniversityById(Long id) {
        return groupUniversityRepository.findById(id).orElse(null);
    }
    public List<groupUniversity> readByCategoryId(Long id) {
        return groupUniversityRepository.findByFaculty(id);
    }
    public void delete(Long id) {
        groupUniversityRepository.deleteById(id);
    }
}
