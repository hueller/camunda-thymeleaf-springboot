package de.hsansbach.ecommerce.engine;

import org.camunda.bpm.engine.impl.bpmn.parser.AbstractBpmnParseListener;

import de.hsansbach.ecommerce.engine.LoggingListeners.LoggingExecutionListener;
import de.hsansbach.ecommerce.engine.LoggingListeners.LoggingStartEndEventExecutionListener;
import de.hsansbach.ecommerce.engine.LoggingListeners.LoggingTransitionListener;
import de.hsansbach.ecommerce.engine.LoggingListeners.LoggingUserTaskExecutionListener;

public abstract class LoggingBpmnParseListener extends AbstractBpmnParseListener {

	protected final LoggingExecutionListener loggingExecutionListener;
	protected final LoggingTransitionListener loggingTransitionListener;
	protected final LoggingUserTaskExecutionListener loggingUserTaskExecutionListener;
	protected final LoggingStartEndEventExecutionListener loggingStartEndEventExecutionListener;

	public LoggingBpmnParseListener() {
		LoggingListeners loggingListeners = new LoggingListeners();
		loggingExecutionListener = loggingListeners.executionListener;
		loggingTransitionListener = loggingListeners.transitionListener;
		loggingUserTaskExecutionListener = loggingListeners.userTaskExecutionListener;
		loggingStartEndEventExecutionListener = loggingListeners.startEndEventExecutionListener;
	}

}