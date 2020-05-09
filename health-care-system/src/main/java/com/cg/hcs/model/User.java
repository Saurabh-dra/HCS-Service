package com.cg.hcs.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = "username") })
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "Please Enter Email")
	@Email		
	@Pattern(regexp = "^(?=.*?[A-Z])(?=.*[$@$!%*?&])(?=.*?[a-z])(?=.*?[0-9]).{8,14}$", message = "Password in Invalid Format")
	private String username;
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

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	public User() {
	}

	public User(String username, String firstName, String lastName, long contactNo, String password) {
		this.username = username;
		this.firstName = firstName;
		this.contactNo = contactNo;
		this.lastName = lastName;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getContactNo() {
		return contactNo;
	}

	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}
