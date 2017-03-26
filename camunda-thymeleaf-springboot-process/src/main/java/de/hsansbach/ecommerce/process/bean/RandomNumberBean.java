package de.hsansbach.ecommerce.process.bean;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Service;

@Service
public class RandomNumberBean {

	public int execute() {
		int randomNumber = ThreadLocalRandom.current().nextInt(100);

		return randomNumber;
	}

}
