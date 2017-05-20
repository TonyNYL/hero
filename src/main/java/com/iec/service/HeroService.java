package com.iec.service;

import com.iec.domain.Category;
import com.iec.domain.Hero;

import java.util.Collection;
import java.util.Set;


/**
 * Created by Tony on 2017/5/18.
 */
public interface HeroService {
    Collection<Hero> getAllHero();

    void createHero(Hero hero);

    Set<Hero> getCategoryHeros(Category category);
}
