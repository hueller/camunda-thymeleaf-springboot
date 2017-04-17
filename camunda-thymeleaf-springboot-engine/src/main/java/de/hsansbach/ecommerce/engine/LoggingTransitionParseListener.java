package de.hsansbach.ecommerce.engine;

import org.camunda.bpm.engine.impl.pvm.process.ScopeImpl;
import org.camunda.bpm.engine.impl.pvm.process.TransitionImpl;
import org.camunda.bpm.engine.impl.util.xml.Element;

public class LoggingTransitionParseListener extends LoggingBpmnParseListener {

	@SuppressWarnings("deprecation")
	@Override
	public void parseSequenceFlow(Element sequenceFlowElement, ScopeImpl scopeElement, TransitionImpl transition) {
		transition.addExecutionListener(loggingTransitionListener);
		super.parseSequenceFlow(sequenceFlowElement, scopeElement, transition);
	}

}