package com.movieflix.movieflix.controller;


import com.movieflix.movieflix.entity.Category;
import com.movieflix.movieflix.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movieflix/category")
@RequiredArgsConstructor
public class CategoryController {


    private final CategoryService categoryService;


    @GetMapping
    public List<Category> getAllCategories(){
        return categoryService.findAll();

    }

    @PostMapping
    public Category saveCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);

    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id){
        Optional<Category> optionalCategory = categoryService.findById(id);
        if(optionalCategory.isPresent()){
            return optionalCategory.get();
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteCategoryById(@PathVariable Long id){
        categoryService.deleteCategoryById(id);
    }
}
