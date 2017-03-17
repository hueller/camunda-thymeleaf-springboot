package de.hsansbach.ecommerce.mvc;

import java.util.List;

import javax.validation.Valid;

import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.task.Task;
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

import de.hsansbach.ecommerce.mvc.model.TaskModel;

@Controller
@RequestMapping("/tasks")
public class TasksController {

	private TaskService taskService;

	public TasksController(TaskService taskService) {
		this.taskService = taskService;
	}

	@GetMapping()
	public String tasks(@AuthenticationPrincipal User user, @ModelAttribute TaskModel taskModel, Model model) {
		List<Task> assignedTasks = taskService.createTaskQuery().taskAssignee(user.getUsername()).list();
		model.addAttribute("assignedTasks", assignedTasks);

		return "tasks";
	}
	
	@PostMapping()
	public ModelAndView complete(@Valid TaskModel taskModel, RedirectAttributes redirect) {
		taskService.complete(taskModel.getId());
		
		redirect.addFlashAttribute("globalMessage", "Successfully completed task id " + taskModel.getId() + ".");
		return new ModelAndView("redirect:/tasks");
	}

}
