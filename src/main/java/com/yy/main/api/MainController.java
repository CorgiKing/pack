package com.yy.main.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/error")
	public String error(){
		return "error";
	}
}
