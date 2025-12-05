package com.movieflix.movieflix.service;


import com.movieflix.movieflix.entity.Category;
import com.movieflix.movieflix.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;


    public List<Category> findAll(){
        return categoryRepository.findAll();

    }

    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Optional<Category> findById(Long Id) {
        return categoryRepository.findById(Id);

    }

    public void deleteCategoryById(Long Id) {
        categoryRepository.deleteById(Id);
    }

}
