package br.com.wesley.teste3wings.controller;

import br.com.wesley.teste3wings.dto.CategoryDto;
import br.com.wesley.teste3wings.model.Category;
import br.com.wesley.teste3wings.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<Category> createCategory(@Valid @RequestBody final CategoryDto categoryData) {
        final Category createdCategory = categoryService.createCategory(categoryData);

        return new ResponseEntity<Category>(createdCategory, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Category>> readCategories() {
        final List<Category> allCategories = categoryService.readCategories();

        return new ResponseEntity<List<Category>>(allCategories, HttpStatus.OK);
    }
}
