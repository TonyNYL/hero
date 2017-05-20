package com.iec.repository;

import com.iec.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Tony on 2017/5/20.
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findCategoryByName(String category);
}
