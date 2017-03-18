package de.hsansbach.ecommerce.process;

import java.util.Map;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.stereotype.Service;

@Service
public class CamundaProcessService {

	private RuntimeService runtimeService;

	public CamundaProcessService(RuntimeService runtimeService) {
		this.runtimeService = runtimeService;
	}

	public String startProcess(String processDefinitionKey, Map<String, Object> variables) {
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processDefinitionKey, variables);
		return processInstance.getId();
	}

}
