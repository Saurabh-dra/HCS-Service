package com.cg.hcs.payload.request;

import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class SignupRequest {
	@NotBlank
	@Email
	@Pattern(regexp = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$", message = "Invalid Email Type")
	private String username;
	@NotBlank
	@NotEmpty(message = "Please Enter First Name")
	@Pattern(regexp = "^([A-Z][a-z]*((\\s[A-Za-z])?[a-z]*)*)$", message = "First Letter must be capital")
	private String firstName;
	@NotEmpty(message = "Please Enter Last Name")
	@Pattern(regexp = "^([A-Z][a-z]*((\\s[A-Za-z])?[a-z]*)*)$", message = "First Letter must be capital")
	private String lastName;
	@NotNull(message = "Please Enter Contact Number")
	@Pattern(regexp = "^[1-9][0-9]{9}$", message = "Invalid phone number should be 10digit and must not start with 0")
	private long contactNo;
	@NotEmpty(message = "Please Enter Password")
	@Pattern(regexp = "^(?=.*?[A-Z])(?=.*[$@$!%*?&])(?=.*?[a-z])(?=.*?[0-9]).{8,14}$", message = "Password in Invalid Format")
	private String password;

	private Set<String> role;

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

	public Set<String> getRole() {
		return this.role;
	}

	public void setRole(Set<String> role) {
		this.role = role;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getContactNo() {
		return contactNo;
	}

	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}
}
