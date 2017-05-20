package com.iec.Controller;

import com.iec.domain.Category;
import com.iec.service.CategoryService;
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

    @Autowired
    private CategoryService categoryService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage(Model model){
        model.addAttribute("heros", heroService.getAllHero());
        model.addAttribute("categories", categoryService.getAllCategory());
        return "index";
    }

}

