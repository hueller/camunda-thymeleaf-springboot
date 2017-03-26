package de.hsansbach.ecommerce.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController extends AbstractController {
	
	@GetMapping()
	public String home() {
		return "home";
	}

}
