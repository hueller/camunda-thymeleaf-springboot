package de.hsansbach.ecommerce.engine;

import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.camunda.bpm.engine.impl.pvm.process.ActivityImpl;
import org.camunda.bpm.engine.impl.pvm.process.ScopeImpl;
import org.camunda.bpm.engine.impl.util.xml.Element;

public class LoggingExecutionParseListener extends LoggingBpmnParseListener {

	@Override
	public void parseExclusiveGateway(Element exclusiveGwElement, ScopeImpl scope, ActivityImpl activity) {
		activity.addExecutionListener(ExecutionListener.EVENTNAME_START, loggingExecutionListener);
		super.parseExclusiveGateway(exclusiveGwElement, scope, activity);
	}

	@Override
	public void parseInclusiveGateway(Element inclusiveGwElement, ScopeImpl scope, ActivityImpl activity) {
		activity.addExecutionListener(ExecutionListener.EVENTNAME_START, loggingExecutionListener);
		super.parseInclusiveGateway(inclusiveGwElement, scope, activity);
	}

	@Override
	public void parseParallelGateway(Element parallelGwElement, ScopeImpl scope, ActivityImpl activity) {
		activity.addExecutionListener(ExecutionListener.EVENTNAME_START, loggingExecutionListener);
		super.parseParallelGateway(parallelGwElement, scope, activity);
	}

	@Override
	public void parseScriptTask(Element scriptTaskElement, ScopeImpl scope, ActivityImpl activity) {
		activity.addExecutionListener(ExecutionListener.EVENTNAME_START, loggingExecutionListener);
		super.parseScriptTask(scriptTaskElement, scope, activity);
	}

	@Override
	public void parseServiceTask(Element serviceTaskElement, ScopeImpl scope, ActivityImpl activity) {
		activity.addExecutionListener(ExecutionListener.EVENTNAME_START, loggingExecutionListener);
		super.parseServiceTask(serviceTaskElement, scope, activity);
	}

}