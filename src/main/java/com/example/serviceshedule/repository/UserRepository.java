package com.example.serviceshedule.repository;


import com.example.serviceshedule.entity.UserSсhedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<UserSсhedule, Long> {
    @Query(
            value = "SELECT * FROM user_shedule where user_shedule.role_id = ?1",
            nativeQuery = true
    )
    List<UserSсhedule> findByRole(Long faculty_id);
}
