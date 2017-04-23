package de.hsansbach.ecommerce.process.model;

import org.hibernate.validator.constraints.NotEmpty;

public class CompleteTasksModel {

	@NotEmpty(message = "Id is required.")
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
