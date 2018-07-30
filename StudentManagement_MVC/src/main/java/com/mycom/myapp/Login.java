package com.mycom.myapp;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Login {
	// �ʵ�
	@NotNull(message="�ʼ� �Է��Դϴ�.")
	@Email(message="�߸��� �̸��� �ּ��Դϴ�.")
	private String user_id;
	
	@NotNull(message="�ʼ� �Է��Դϴ�.")
	@Size(min=4, message="��й�ȣ�� �ּ� 4���� �̻��Դϴ�.")
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
