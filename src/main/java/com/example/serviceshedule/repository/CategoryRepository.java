package com.example.serviceshedule.repository;

import com.example.serviceshedule.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
