package com.iec.Controller;

import com.iec.domain.Category;
import com.iec.domain.Hero;
import com.iec.service.CategoryService;
import com.iec.service.HeroService;
import com.iec.stroage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


/**
 * Created by Tony on 2017/5/18.
 */
@Controller
@RequestMapping("/hero")
public class HeroController {

    @Autowired
    private HeroService heroService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private StorageService storageService;

    @RequestMapping(value = "/{category}", method = RequestMethod.GET)
    public String heroPage(@PathVariable("category") String name, Model model){
        Category category = categoryService.getCategory(name);
        category.setHeroes(heroService.getCategoryHeros(category));
        model.addAttribute("heros", category.getHeroes());
        model.addAttribute("categories", categoryService.getAllCategory());
        return "index";
    }

    @GetMapping("/add")
    public String addHeroPage(Model model){
        model.addAttribute("categories", categoryService.getAllCategory());
        return "add";
    }

    @PostMapping("/add")
    public String handleAddHeroPage(@RequestParam("name") String name, @RequestParam("picture") MultipartFile picture , @RequestParam("category") String category) {
        storageService.store(picture);
        heroService.createHero(new Hero(name, picture.getOriginalFilename(), categoryService.getCategory(category)));
        return "redirect:/";
    }


}
