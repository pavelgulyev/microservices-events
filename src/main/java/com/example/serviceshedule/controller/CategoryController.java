package com.example.serviceshedule.controller;

import com.example.serviceshedule.entity.Category;
import com.example.serviceshedule.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/webshedule")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @PostMapping("/category")
    public ResponseEntity<Category> create(@RequestBody Category dto) {
        return mappingResponseCategory(categoryService.createCategory(dto));
    }
    @GetMapping("/categories")
    public ResponseEntity<List<Category>> readAll() {
        return mappingResponseListCategory(categoryService.readAll());
    }
    @GetMapping("/category/{id}")
    public ResponseEntity<Category> fingById(@PathVariable Long id) {
        Category findFaculty = categoryService.getFacultyById(id);

        if (findFaculty ==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return mappingResponseCategory(findFaculty);
    }
    @PutMapping("/category/{id}")
    public ResponseEntity<Category> update(@PathVariable Long id,
                                          @RequestBody Category faculty) {
        return mappingResponseCategory(categoryService.update(faculty));
    }
    private ResponseEntity<Category> mappingResponseCategory(Category category) {
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
    @DeleteMapping("/category/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        categoryService.delete(id);
        return HttpStatus.OK;
    }

    private ResponseEntity<List<Category>> mappingResponseListCategory(List<Category> categories) {
        if (categories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
}
