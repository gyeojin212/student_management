package com.mycom.myapp;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Login {
	// 필드
	@NotNull(message="필수 입력입니다.")
	@Email(message="잘못된 이메일 주소입니다.")
	private String user_id;
	
	@NotNull(message="필수 입력입니다.")
	@Size(min=4, message="비밀번호는 최소 4글자 이상입니다.")
	private String password;

	public Login() {
		super();
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
