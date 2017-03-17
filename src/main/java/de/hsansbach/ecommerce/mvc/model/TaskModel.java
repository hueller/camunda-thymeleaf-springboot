package de.hsansbach.ecommerce.mvc.model;

import org.hibernate.validator.constraints.NotEmpty;

public class TaskModel {

	@NotEmpty(message = "Id is required.")
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
