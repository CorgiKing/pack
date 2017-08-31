package com.yy.main.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {
	
	@GetMapping(value ={"","/","/index"})
	public String index(){
		return "homepage";
	}
	
}
