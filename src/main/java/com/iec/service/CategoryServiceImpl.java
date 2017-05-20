package com.iec.service;

import com.iec.domain.Category;
import com.iec.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

/**
 * Created by Tony on 2017/5/20.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Collection<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategory(String category) {
        return categoryRepository.findCategoryByName(category);
    }
}
