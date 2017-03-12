package de.hsansbach.ecommerce;

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableProcessApplication
public class CamundaSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(CamundaSpringbootApplication.class, args);
	}
}
