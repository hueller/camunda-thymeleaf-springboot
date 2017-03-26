package de.hsansbach.ecommerce.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;

import de.hsansbach.ecommerce.process.CamundaProcessService;

public abstract class AbstractController {
	
	@Autowired
	protected CamundaProcessService camundaProcessService;

}
