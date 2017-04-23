package de.hsansbach.ecommerce.process.model;

import org.hibernate.validator.constraints.NotEmpty;

public class UserTaskModel {

	@NotEmpty(message = "Text is required.")
	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
