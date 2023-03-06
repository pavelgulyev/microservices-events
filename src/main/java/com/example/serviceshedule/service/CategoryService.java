package com.example.serviceshedule.service;

import com.example.serviceshedule.entity.Category;
import com.example.serviceshedule.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repository;
//    public Faculty create(FacultyDto dto) {
//        return repository.save(Faculty.builder()
//                .nameFaculty(dto.getNameFaculty())
//                .build());
//    }
    public Category createCategory(Category category) {
        Category newcategory = new Category();
        newcategory.setNameCategory(category.getNameCategory());
        return repository.save(newcategory);
    }
    public List<Category> readAll() {
        return repository.findAll();
    }
    public Category update(Category category) {
        return repository.save(category);
    }
    public Category getFacultyById(Long id) {
        return repository.findById(id).orElse(null);
    }
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
