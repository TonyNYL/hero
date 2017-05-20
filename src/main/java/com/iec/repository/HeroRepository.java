package com.iec.repository;

import com.iec.domain.Hero;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

/**
 * Created by Tony on 2017/5/18.
 */
public interface HeroRepository extends JpaRepository<Hero, Long> {

    Collection<Hero> findHeroByCategory(String category);
}
