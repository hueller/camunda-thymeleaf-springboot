package de.hsansbach.ecommerce.engine;

import java.util.Map.Entry;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.camunda.bpm.engine.impl.persistence.entity.ExecutionEntity;
import org.camunda.bpm.engine.variable.VariableMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractLoggingListener implements ExecutionListener {

	protected static final Logger LOG = LoggerFactory.getLogger(AbstractLoggingListener.class);

	@Override
	public void notify(DelegateExecution execution) throws Exception {
		if (execution instanceof ExecutionEntity) {
			ExecutionEntity ee = (ExecutionEntity) execution;
			notifyExecution(ee);
		}
	}

	protected abstract void notifyExecution(ExecutionEntity execution);

	protected void logExecution(ExecutionEntity execution) {
		LOG.info(">>>>>[{}] {} ", execution.getId(), execution.getActivity().getId());
		LOG.info("          variables [{}]: {}", execution.getId(), convertToString(execution.getVariables()));
	}

	protected void logExecution(ExecutionEntity execution, String processDefinitionId) {
		LOG.info(">>>>>[{}] {} " + processDefinitionId, execution.getId(), execution.getActivity().getId());
		LOG.info("          variables [{}]: {}", execution.getId(), convertToString(execution.getVariables()));
	}

	private String convertToString(VariableMap variableMap) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("{");
		
		boolean isFirst = true;
		for (Entry<String, Object> variable : variableMap.entrySet()) {
			if (!isFirst) {
				stringBuilder.append(", ");
			}
			stringBuilder.append(variable.getKey());
			stringBuilder.append(" => ");
			stringBuilder.append(variable.getValue());
			isFirst = false;
		}
		
		stringBuilder.append("}");
		return stringBuilder.toString();
	}

}