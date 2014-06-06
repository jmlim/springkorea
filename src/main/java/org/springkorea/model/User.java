package org.springkorea.model;

import java.io.Serializable;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author Administrator
 * 
 */
public class User implements Serializable {

	private static final long serialVersionUID = 6582137205440661975L;

	@NotBlank
	@Size(max = 15)
	private String uid;

	@NotBlank
	@Size(max = 50)
	private String name;

	@Email
	private String email;

	@NotBlank
	@Size(max = 15)
	private String password;

	public User() {
		super();
	}

	public User(String uid) {
		super();
		this.uid = uid;
	}

	public User(String uid, String password) {
		super();
		this.uid = uid;
		this.password = password;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User information ( uid : " + this.getUid() + ", name : "
				+ this.getName() + ", email : " + this.getEmail() + ")";
	}
}
