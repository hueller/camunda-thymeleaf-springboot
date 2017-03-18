package de.hsansbach.ecommerce.process.bean;

import java.util.concurrent.ThreadLocalRandom;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class RandomNumberDelegate implements JavaDelegate {

	@Override
	public void execute(DelegateExecution delegateExecution) throws Exception {
		int randomNumber = ThreadLocalRandom.current().nextInt(100);

		delegateExecution.setVariable("randomNumberDelegate", randomNumber);
	}

}
