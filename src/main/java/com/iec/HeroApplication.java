package com.iec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class HeroApplication {

//	@RequestMapping("/")
//	@ResponseBody
//	String home(){
//		return "欢迎来到王者荣耀！！！";
//	}

	public static void main(String[] args) {
		SpringApplication.run(HeroApplication.class, args);
	}
}
