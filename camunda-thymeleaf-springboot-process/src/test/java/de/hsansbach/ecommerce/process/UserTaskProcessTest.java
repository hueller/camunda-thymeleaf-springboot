package de.hsansbach.ecommerce.process;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.camunda.bpm.engine.impl.ProcessEngineImpl;
import org.camunda.bpm.engine.impl.test.TestHelper;
import org.camunda.bpm.engine.task.Task;
import org.camunda.bpm.engine.test.Deployment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.hsansbach.ecommerce.CamundaThymeleafSpringbootProcess;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CamundaThymeleafSpringbootProcess.class)
public class UserTaskProcessTest extends AbstractProcessTest {

	@Test
	@Deployment
	public void simpleProcessTest() {
		camundaProcessService.startProcess(ProcessKey.USER_TASK, defaultVariables());
		
		TestHelper.waitForJobExecutorToProcessAllJobs(((ProcessEngineImpl) processEngine).getProcessEngineConfiguration(), 10000, 50);

		Task task = camundaProcessService.getTaskService().createTaskQuery().singleResult();
		assertEquals("Confirmation User Task", task.getName());
		assertEquals(defaultAssignee, task.getAssignee());
		
		camundaProcessService.completeTask(task.getId());

		assertEquals(0, camundaProcessService.getRuntimeService().createProcessInstanceQuery().count());
	}
	
	private Map<String, Object> defaultVariables() {
		Map<String, Object> variables = new HashMap<>();
		variables.put("assignee", defaultAssignee);
		variables.put("text", defaultText);
		return variables;
	}

}
