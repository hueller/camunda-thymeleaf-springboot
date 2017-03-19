package de.hsansbach.ecommerce.process;

import java.util.List;
import java.util.Map;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CamundaProcessService {

	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	private TaskService taskService;

	public String startProcess(String processDefinitionKey, Map<String, Object> variables) {
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processDefinitionKey, variables);
		return processInstance.getId();
	}

	public List<Task> getTasksForAssigne(String assigne) {
		return taskService.createTaskQuery().taskAssignee(assigne).list();
	}
	
	public void completeTask(String taskId) {
		completeTask(taskId, null);
	}

	public void completeTask(String taskId, Map<String, Object> variables) {
		taskService.complete(taskId, variables);
	}

}
