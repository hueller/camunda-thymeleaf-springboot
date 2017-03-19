package de.hsansbach.ecommerce.mvc;

import java.util.List;

import javax.validation.Valid;

import org.camunda.bpm.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import de.hsansbach.ecommerce.mvc.model.TasksModel;
import de.hsansbach.ecommerce.process.CamundaProcessService;

@Controller
@RequestMapping("/tasks")
public class TasksController {

	@Autowired
	private CamundaProcessService camundaProcessService;

	@GetMapping()
	public String tasks(@AuthenticationPrincipal User user, @ModelAttribute TasksModel taskModel, Model model) {
		List<Task> assignedTasks = camundaProcessService.getTasksForAssigne(user.getUsername());
		model.addAttribute("assignedTasks", assignedTasks);

		return "tasks";
	}
	
	@PostMapping()
	public ModelAndView complete(@Valid TasksModel taskModel, RedirectAttributes redirect) {
		camundaProcessService.completeTask(taskModel.getId());
		
		redirect.addFlashAttribute("globalMessage", "Successfully completed task id " + taskModel.getId() + ".");
		return new ModelAndView("redirect:/tasks");
	}

}
