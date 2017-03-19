package de.hsansbach.ecommerce.process;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.impl.ProcessEngineImpl;
import org.camunda.bpm.engine.impl.test.TestHelper;
import org.camunda.bpm.engine.task.Task;
import org.camunda.bpm.engine.test.Deployment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.hsansbach.ecommerce.CamundaSpringbootThymeleafApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CamundaSpringbootThymeleafApplication.class)
public class SampleProcessTest extends AbstractProcessTest {
	
	@Autowired
	private ProcessEngine processEngine;

	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	private TaskService taskService;

	@Test
	@Deployment
	public void simpleProcessTest() {
		runtimeService.startProcessInstanceByKey("Sample", defaultVariables());
		
		TestHelper.waitForJobExecutorToProcessAllJobs(((ProcessEngineImpl) processEngine).getProcessEngineConfiguration(), 10000, 50);

		Task task = taskService.createTaskQuery().singleResult();
		assertEquals("Confirmation User Task", task.getName());
		assertEquals(defaultAssignee, task.getAssignee());
		
		taskService.complete(task.getId());

		assertEquals(0, runtimeService.createProcessInstanceQuery().count());
	}
	
	private Map<String, Object> defaultVariables() {
		Map<String, Object> variables = new HashMap<>();
		variables.put("assignee", defaultAssignee);
		variables.put("text", defaultText);
		return variables;
	}

}
