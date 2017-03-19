package de.hsansbach.ecommerce.mvc;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import de.hsansbach.ecommerce.mvc.model.ProcessModel;
import de.hsansbach.ecommerce.process.CamundaProcessService;

@Controller
@RequestMapping("/processes")
public class ProcessesController {

	@Autowired
	private CamundaProcessService camundaProcessService;

	@GetMapping()
	public String processes(@ModelAttribute ProcessModel processModel) {
		return "processes";
	}

	@PostMapping()
	public ModelAndView startProcess(@AuthenticationPrincipal User user, @Valid ProcessModel processModel, BindingResult result,
			RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return new ModelAndView("processes", "formErrors", result.getAllErrors());
		}

		Map<String, Object> variables = new HashMap<>();
		variables.put("assignee", user.getUsername());
		variables.put("text", processModel.getText());
		camundaProcessService.startProcess("Sample", variables);

		redirect.addFlashAttribute("globalMessage", "Successfully started process 'Sample'.");
		return new ModelAndView("redirect:/processes");
	}
}
