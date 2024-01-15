package com.ardakavas.LibraryAutomation.service;


import com.ardakavas.LibraryAutomation.model.Category;
import com.ardakavas.LibraryAutomation.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }
    //Get all Categories
    public List<Category> getAllCategories(){return categoryRepository.findAll();}

    //Get Category by Id
    public Optional<Category> getCategoryById(Long categoryId) {
        return categoryRepository.findById(categoryId);
    }

    // Update Category
    public Category updateCategory(Long category_id, Category updatedCategory) {
        Optional<Category> existingCategory = categoryRepository.findById(category_id);
        if (existingCategory.isPresent()) {
            updatedCategory.setCategory_id(category_id);
            return categoryRepository.save(updatedCategory);
        }
        throw new IllegalArgumentException("Category not found with id: " + category_id);
    }

    // Add Category
    public Category createCategory(Category category){return categoryRepository.save(category);}

    // Delete Category
    public void deleteCategory(Long category_id){
        if(categoryRepository.existsById(category_id)){
            categoryRepository.deleteById(category_id);
        }else{
            throw new IllegalArgumentException("Category not found with id: " + category_id);
        }
    }


}
