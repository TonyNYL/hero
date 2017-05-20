package com.iec.service;

import com.iec.domain.Hero;
import com.iec.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Tony on 2017/5/18.
 */
@Service
public class HeroServiceImpl implements HeroService {

    @Autowired//注入对象
    private HeroRepository heroRepository;

    @Override
    public Collection<Hero> getAllHero() {
        return heroRepository.findAll();
    }

    @Override
    public void createHero(Hero hero) {
        heroRepository.save(hero);
    }

    @Override
    public Collection<Hero> getHerosByCategory(String category) {
        return heroRepository.findHeroByCategory(category);
    }
}
