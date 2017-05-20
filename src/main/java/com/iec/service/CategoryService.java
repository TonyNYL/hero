package com.iec.service;

import com.iec.domain.Category;

import java.util.Collection;

/**
 * Created by Tony on 2017/5/20.
 */
public interface CategoryService {
    Collection<Category> getAllCategory();

    Category getCategory(String category);
}

