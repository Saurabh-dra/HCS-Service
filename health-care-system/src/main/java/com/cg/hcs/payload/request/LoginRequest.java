package com.cg.hcs.payload.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class LoginRequest {
	@NotBlank
	@Pattern(regexp = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$", message = "Invalid Email Type")
	private String username;

	@NotBlank
	@Pattern(regexp = "^(?=.*?[A-Z])(?=.*[$@$!%*?&])(?=.*?[a-z])(?=.*?[0-9]).{8,14}$", message = "Password in Invalid Format")
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
