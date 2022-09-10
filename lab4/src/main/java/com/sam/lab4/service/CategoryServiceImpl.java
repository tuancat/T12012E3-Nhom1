package com.sam.lab4.service;

import com.sam.lab4.model.Category;
import com.sam.lab4.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public List<Category> getCategoryList() {
        return categoryRepository.findAll();
    }
}
