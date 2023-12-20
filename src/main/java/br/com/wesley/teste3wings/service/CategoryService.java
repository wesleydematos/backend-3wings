package br.com.wesley.teste3wings.service;

import br.com.wesley.teste3wings.dto.CategoryDto;
import br.com.wesley.teste3wings.model.Category;
import br.com.wesley.teste3wings.repository.CategoryRepository;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category createCategory(final CategoryDto categoryData) {
        final Category category = new Category(categoryData.getName());

        return categoryRepository.save(category);
    }

    public List<Category> readCategories() {
        return categoryRepository.findAll();
    }
}
