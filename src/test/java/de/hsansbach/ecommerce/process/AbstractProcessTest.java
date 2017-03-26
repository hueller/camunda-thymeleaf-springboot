package de.hsansbach.ecommerce.process;

import org.camunda.bpm.engine.ProcessEngine;
import org.springframework.beans.factory.annotation.Autowired;

import de.hsansbach.ecommerce.process.CamundaProcessService;

public abstract class AbstractProcessTest {
	
	@Autowired
	protected ProcessEngine processEngine;

	@Autowired
	protected CamundaProcessService camundaProcessService;
	
	protected String defaultAssignee = "Kermit";
	protected String defaultText = "Test";

}
