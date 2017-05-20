package com.iec.service;

import com.iec.domain.Hero;

import java.util.Collection;


/**
 * Created by Tony on 2017/5/18.
 */
public interface HeroService {
    Collection<Hero> getAllHero();

    void createHero(Hero hero);

    Collection<Hero> getHerosByCategory(String category);
}
