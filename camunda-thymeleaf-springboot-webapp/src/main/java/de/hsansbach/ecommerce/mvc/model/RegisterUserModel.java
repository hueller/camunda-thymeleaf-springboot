package de.hsansbach.ecommerce.mvc.model;

import org.hibernate.validator.constraints.NotEmpty;

public class RegisterUserModel {
	
	@NotEmpty(message = "User is required.")
	private String user;
	
	@NotEmpty(message = "Password is required.")
	private String password;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
