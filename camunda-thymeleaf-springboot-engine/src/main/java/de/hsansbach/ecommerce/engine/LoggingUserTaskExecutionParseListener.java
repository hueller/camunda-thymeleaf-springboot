package de.hsansbach.ecommerce.engine;

import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.camunda.bpm.engine.impl.pvm.process.ActivityImpl;
import org.camunda.bpm.engine.impl.pvm.process.ScopeImpl;
import org.camunda.bpm.engine.impl.util.xml.Element;

public class LoggingUserTaskExecutionParseListener extends LoggingBpmnParseListener {

	@SuppressWarnings("deprecation")
	@Override
	public void parseUserTask(Element userTaskElement, ScopeImpl scope, ActivityImpl activity) {
		activity.addExecutionListener(ExecutionListener.EVENTNAME_START, loggingUserTaskExecutionListener);
		super.parseUserTask(userTaskElement, scope, activity);
	}

}