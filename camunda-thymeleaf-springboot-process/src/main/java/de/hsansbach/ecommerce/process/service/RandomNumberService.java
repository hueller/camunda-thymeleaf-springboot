package de.hsansbach.ecommerce.process.service;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Service;

@Service
public class RandomNumberService {

	public int execute() {
		int randomNumber = ThreadLocalRandom.current().nextInt(100);

		return randomNumber;
	}

}
