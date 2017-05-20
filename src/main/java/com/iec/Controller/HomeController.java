package com.iec.Controller;

import com.iec.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Tony on 2017/5/18.
 */
@Controller
@RequestMapping("")
public class HomeController {

    @Autowired
    private HeroService heroService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView homePage(){
        return new  ModelAndView("index","heros", heroService.getAllHero());
    }

}

