package de.hsansbach.ecommerce.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/processes")
public class ProcessesController {

	@GetMapping()
	public String processes() {
		return "processes";
	}

}
