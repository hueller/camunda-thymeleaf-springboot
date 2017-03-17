package de.hsansbach.ecommerce.mvc.model;

import org.hibernate.validator.constraints.NotEmpty;

public class ProcessModel {

	@NotEmpty(message = "Text is required.")
	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
