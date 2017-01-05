package it.alarit.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("/home")
public class HomeController {

	@GetMapping
	public ModelAndView showHome(){
		return new ModelAndView("home");
	}
	
}
