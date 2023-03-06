package com.example.serviceshedule.repository;


import com.example.serviceshedule.entity.groupUniversity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GroupUniversityRepository extends JpaRepository<groupUniversity, Long> {
    @Query(
            value = "SELECT * FROM group_university where group_university.faculty_id = ?1",
            nativeQuery = true
    )
    List<groupUniversity> findByFaculty(Long faculty_id);
}
