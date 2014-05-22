package org.springkorea.model;

import java.io.Serializable;

/**
 * @author Administrator
 * 
 */
public class User implements Serializable {

	private static final long serialVersionUID = 6582137205440661975L;

	private String uid;

	private String name;

	private String email;

	private String password;

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