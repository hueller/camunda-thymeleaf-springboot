package de.hsansbach.ecommerce.engine;

import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.camunda.bpm.engine.impl.pvm.process.ActivityImpl;
import org.camunda.bpm.engine.impl.pvm.process.ScopeImpl;
import org.camunda.bpm.engine.impl.util.xml.Element;

public class LoggingStartEndEventExecutionParseListener extends LoggingBpmnParseListener {

	@SuppressWarnings("deprecation")
	@Override
	public void parseStartEvent(Element startEventElement, ScopeImpl scope, ActivityImpl activity) {
		activity.addExecutionListener(ExecutionListener.EVENTNAME_START, loggingStartEndEventExecutionListener);
		super.parseStartEvent(startEventElement, scope, activity);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void parseEndEvent(Element endEventElement, ScopeImpl scope, ActivityImpl activity) {
		activity.addExecutionListener(ExecutionListener.EVENTNAME_START, loggingStartEndEventExecutionListener);
		super.parseEndEvent(endEventElement, scope, activity);
	}

}