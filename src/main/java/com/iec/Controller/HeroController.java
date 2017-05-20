package com.iec.Controller;

import com.iec.domain.Hero;
import com.iec.service.HeroService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by Tony on 2017/5/18.
 */
@Controller
@RequestMapping("/hero")
public class HeroController {

    @Autowired
    private HeroService heroService;

    //获取上传的文件夹，具体路径参考application.properties中的配置
    @Value("${web.upload-path}")
    private String uploadPath;


    @RequestMapping(value = "/{category}", method = RequestMethod.GET)
    public ModelAndView heroPage(@PathVariable("category") String category){

        return new  ModelAndView("index","heros", heroService.getHerosByCategory(category));
    }

    /**
     * GET请求
     * 上传页面，也将显示已经存在的文件
     * @param model
     * @return
     */
    @GetMapping(value = "/add")
    public String index(Model model, Hero hero ) {
        //获取已存在的文件
        File[] files = new File(uploadPath).listFiles();
        model.addAttribute("files", files);
        return "add";
    }

    /**
     * POST请求
     * @param request
     * @param file
     * @return
     */
    @PostMapping(value = "add")
    public String add(HttpServletRequest request, @RequestParam("picture")MultipartFile file, @RequestParam("name")String name, @RequestParam("category")String category  ) {
        //可以从页面传参数过来
        System.out.println("name====="+request.getParameter("name"));
        String fileName = null;
        //这里可以支持多文件上传
        if(file!=null) {
            BufferedOutputStream bw = null;
            try {
                fileName = file.getOriginalFilename();
                //判断是否有文件且是否为图片文件
                if(fileName!=null && !"".equalsIgnoreCase(fileName.trim()) && isImageFile(fileName)) {
                    //创建输出文件对象
                    File outFile = new File(uploadPath + "/" + UUID.randomUUID().toString()+ getFileType(fileName));
                    //拷贝文件到输出文件对象
                    FileUtils.copyInputStreamToFile(file.getInputStream(), outFile);
                    Hero hero =new Hero(name,category,outFile.getName());
                    hero.setPicture(outFile.getName());
                    heroService.createHero(hero);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if(bw!=null) {bw.close();}
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return "redirect:/";
    }

    /**
     * 判断文件是否为图片文件
     * @param fileName
     * @return
     */
    private Boolean isImageFile(String fileName) {
        String [] img_type = new String[]{".jpg", ".jpeg", ".png", ".gif", ".bmp"};
        if(fileName==null) {return false;}
        fileName = fileName.toLowerCase();
        for(String type : img_type) {
            if(fileName.endsWith(type)) {return true;}
        }
        return false;
    }

    /**
     * 获取文件后缀名
     * @param fileName
     * @return
     */
    private String getFileType(String fileName) {
        if(fileName!=null && fileName.indexOf(".")>=0) {
            return fileName.substring(fileName.lastIndexOf("."), fileName.length());
        }
        return "";
    }
}
