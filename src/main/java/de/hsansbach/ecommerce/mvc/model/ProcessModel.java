package de.hsansbach.ecommerce.mvc.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class ProcessModel {

	@NotEmpty(message = "Text is required.")
	@Size(min=1, max=20)
	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
