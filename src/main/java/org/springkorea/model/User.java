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

	@NotBlank(message = "아이디는 필수값입니다.")
	@Size(min = 5, max = 15, message = "아이디는 최소 5, 최대 15까지만 입력 가능합니다.")
	private String uid;

	@NotBlank(message = "이름은 필수값입니다.")
	@Size(max = 50, message = "이름은 최대 50자까지 입력 가능합니다.")
	private String name;

	@Email(message = "올바른 이메일 주소를 입력하세요.")
	private String email;

	@NotBlank(message = "패스워드는 필수값입니다.")
	@Size(min = 7, max = 15, message = "패스워드는 최소 7, 최대 15까지만 입력 가능합니다.")
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
